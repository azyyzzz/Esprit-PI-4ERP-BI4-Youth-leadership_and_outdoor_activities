"""
alerting.py — Rule-based alerting engine for Scouts MLOps.

Monitors:
  - High latency (p95 > 500ms)
  - High error rate (>5% of requests)
  - Accuracy degradation (>5% below baseline)
  - Drift detection (drift score > threshold)

Alerts are:
  - Logged to monitoring_alerts.log via observability module
  - Exposed as Prometheus gauges (active_alerts)
"""

import time
from collections import deque
from dataclasses import dataclass, field
from typing import List, Optional
from observability import log_alert

# ---------------------------------------------------------------------------
# Configuration
# ---------------------------------------------------------------------------
LATENCY_P95_THRESHOLD_MS = 500.0    # ms
ERROR_RATE_THRESHOLD = 0.05          # 5%
ACCURACY_BASELINE = 0.92
ACCURACY_DROP_THRESHOLD = 0.05       # 5% drop
DRIFT_SCORE_THRESHOLD = 0.30
WINDOW_SIZE = 100                    # rolling window for rate calculations


@dataclass
class Alert:
    name: str
    severity: str        # "warning", "critical"
    message: str
    timestamp: float     # time.time()
    metric_value: float
    threshold: float
    active: bool = True


class AlertingEngine:
    """Evaluates alerting rules against rolling metrics."""

    def __init__(self):
        # Rolling windows
        self._latencies: deque = deque(maxlen=WINDOW_SIZE)
        self._statuses: deque = deque(maxlen=WINDOW_SIZE)  # True=success, False=error
        self._current_accuracy: float = ACCURACY_BASELINE
        self._current_drift_score: float = 0.0

        # Active alerts (keyed by name to avoid duplicates)
        self.active_alerts: dict[str, Alert] = {}

    # ------------------------------------------------------------------
    # Record events
    # ------------------------------------------------------------------

    def record_request(self, latency_ms: float, is_error: bool):
        """Record a request's latency and success/failure."""
        self._latencies.append(latency_ms)
        self._statuses.append(not is_error)

    def update_accuracy(self, accuracy: float):
        self._current_accuracy = accuracy

    def update_drift_score(self, drift_score: float):
        self._current_drift_score = drift_score

    # ------------------------------------------------------------------
    # Evaluate rules
    # ------------------------------------------------------------------

    def evaluate(self) -> List[Alert]:
        """Evaluate all alerting rules. Returns list of newly fired alerts."""
        new_alerts = []

        # Rule 1: High Latency
        if len(self._latencies) >= 10:
            sorted_lat = sorted(self._latencies)
            p95_idx = int(len(sorted_lat) * 0.95)
            p95 = sorted_lat[min(p95_idx, len(sorted_lat) - 1)]
            if p95 > LATENCY_P95_THRESHOLD_MS:
                alert = self._fire_alert(
                    "high_latency",
                    "critical" if p95 > 1000 else "warning",
                    f"P95 latency {p95:.0f}ms exceeds threshold {LATENCY_P95_THRESHOLD_MS}ms",
                    p95,
                    LATENCY_P95_THRESHOLD_MS,
                )
                if alert:
                    new_alerts.append(alert)
            else:
                self._resolve_alert("high_latency")

        # Rule 2: High Error Rate
        if len(self._statuses) >= 10:
            error_count = sum(1 for s in self._statuses if not s)
            error_rate = error_count / len(self._statuses)
            if error_rate > ERROR_RATE_THRESHOLD:
                alert = self._fire_alert(
                    "high_error_rate",
                    "critical" if error_rate > 0.15 else "warning",
                    f"Error rate {error_rate:.1%} exceeds threshold {ERROR_RATE_THRESHOLD:.1%}",
                    error_rate,
                    ERROR_RATE_THRESHOLD,
                )
                if alert:
                    new_alerts.append(alert)
            else:
                self._resolve_alert("high_error_rate")

        # Rule 3: Accuracy Degradation
        acc_drop = ACCURACY_BASELINE - self._current_accuracy
        if acc_drop > ACCURACY_DROP_THRESHOLD:
            alert = self._fire_alert(
                "accuracy_degradation",
                "critical" if acc_drop > 0.10 else "warning",
                f"Accuracy {self._current_accuracy:.2%} is {acc_drop:.1%} below baseline {ACCURACY_BASELINE:.2%}",
                self._current_accuracy,
                ACCURACY_BASELINE - ACCURACY_DROP_THRESHOLD,
            )
            if alert:
                new_alerts.append(alert)
        else:
            self._resolve_alert("accuracy_degradation")

        # Rule 4: Drift Detection
        if self._current_drift_score > DRIFT_SCORE_THRESHOLD:
            alert = self._fire_alert(
                "drift_detected",
                "critical" if self._current_drift_score > 0.6 else "warning",
                f"Drift score {self._current_drift_score:.3f} exceeds threshold {DRIFT_SCORE_THRESHOLD:.3f}",
                self._current_drift_score,
                DRIFT_SCORE_THRESHOLD,
            )
            if alert:
                new_alerts.append(alert)
        else:
            self._resolve_alert("drift_detected")

        return new_alerts

    def get_active_alert_count(self) -> int:
        return sum(1 for a in self.active_alerts.values() if a.active)

    def get_active_alerts_summary(self) -> list:
        return [
            {
                "name": a.name,
                "severity": a.severity,
                "message": a.message,
                "metric_value": a.metric_value,
                "threshold": a.threshold,
                "since": a.timestamp,
            }
            for a in self.active_alerts.values()
            if a.active
        ]

    # ------------------------------------------------------------------
    # Internal
    # ------------------------------------------------------------------

    def _fire_alert(self, name: str, severity: str, message: str,
                    metric_value: float, threshold: float) -> Optional[Alert]:
        """Fire an alert. Returns the alert if it is newly fired."""
        if name in self.active_alerts and self.active_alerts[name].active:
            # Update existing alert metric but don't re-fire
            self.active_alerts[name].metric_value = metric_value
            return None

        alert = Alert(
            name=name,
            severity=severity,
            message=message,
            timestamp=time.time(),
            metric_value=metric_value,
            threshold=threshold,
            active=True,
        )
        self.active_alerts[name] = alert
        # Log to file
        log_alert(name, severity, message)
        # Console Notification for visibility
        print(f"\n[ALERT] [{severity.upper()}] {name.upper()}: {message}\n")
        return alert

    def _resolve_alert(self, name: str):
        """Mark an alert as resolved."""
        if name in self.active_alerts and self.active_alerts[name].active:
            self.active_alerts[name].active = False
            log_alert(name, "resolved", f"Alert '{name}' resolved — metric back to normal")


# ---------------------------------------------------------------------------
# Singleton
# ---------------------------------------------------------------------------
alerting_engine = AlertingEngine()
