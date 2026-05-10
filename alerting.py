import time
from collections import deque
from dataclasses import dataclass
from observability import log_alert

LATENCY_P95_THRESHOLD_MS = 500.0
ERROR_RATE_THRESHOLD = 0.05
ACCURACY_BASELINE = 0.92
ACCURACY_DROP_THRESHOLD = 0.05
DRIFT_SCORE_THRESHOLD = 0.30
WINDOW_SIZE = 100


@dataclass
class Alert:
    name: str
    severity: str
    message: str
    timestamp: float
    metric_value: float
    threshold: float
    active: bool = True


class AlertingEngine:
    def __init__(self):
        self._latencies = deque(maxlen=WINDOW_SIZE)
        self._statuses = deque(maxlen=WINDOW_SIZE)
        self._current_accuracy = ACCURACY_BASELINE
        self._current_drift_score = 0.0
        self.active_alerts = {}

    def record_request(self, latency_ms: float, is_error: bool):
        self._latencies.append(latency_ms)
        self._statuses.append(not is_error)

    def update_accuracy(self, accuracy: float):
        self._current_accuracy = accuracy

    def update_drift_score(self, drift_score: float):
        self._current_drift_score = drift_score

    def evaluate(self):
        new_alerts = []
        if len(self._latencies) >= 10:
            p95 = sorted(self._latencies)[min(int(len(self._latencies) * 0.95), len(self._latencies) - 1)]
            if p95 > LATENCY_P95_THRESHOLD_MS:
                a = self._fire_alert("high_latency", "warning", f"P95 latency {p95:.0f}ms exceeds threshold", p95, LATENCY_P95_THRESHOLD_MS)
                if a:
                    new_alerts.append(a)
            else:
                self._resolve_alert("high_latency")

        if len(self._statuses) >= 10:
            error_rate = sum(1 for s in self._statuses if not s) / len(self._statuses)
            if error_rate > ERROR_RATE_THRESHOLD:
                a = self._fire_alert("high_error_rate", "critical", f"Error rate {error_rate:.1%} exceeds threshold", error_rate, ERROR_RATE_THRESHOLD)
                if a:
                    new_alerts.append(a)
            else:
                self._resolve_alert("high_error_rate")

        acc_drop = ACCURACY_BASELINE - self._current_accuracy
        if acc_drop > ACCURACY_DROP_THRESHOLD:
            a = self._fire_alert("accuracy_degradation", "critical", "Accuracy below baseline threshold", self._current_accuracy, ACCURACY_BASELINE - ACCURACY_DROP_THRESHOLD)
            if a:
                new_alerts.append(a)
        else:
            self._resolve_alert("accuracy_degradation")

        if self._current_drift_score > DRIFT_SCORE_THRESHOLD:
            a = self._fire_alert("drift_detected", "warning", "Drift score exceeds threshold", self._current_drift_score, DRIFT_SCORE_THRESHOLD)
            if a:
                new_alerts.append(a)
        else:
            self._resolve_alert("drift_detected")
        return new_alerts

    def _fire_alert(self, name, severity, message, metric_value, threshold):
        if name in self.active_alerts and self.active_alerts[name].active:
            self.active_alerts[name].metric_value = metric_value
            return None
        alert = Alert(name, severity, message, time.time(), metric_value, threshold, True)
        self.active_alerts[name] = alert
        log_alert(name, severity, message)
        return alert

    def _resolve_alert(self, name):
        if name in self.active_alerts and self.active_alerts[name].active:
            self.active_alerts[name].active = False
            log_alert(name, "resolved", f"Alert '{name}' resolved")

    def get_active_alert_count(self):
        return sum(1 for a in self.active_alerts.values() if a.active)

    def get_active_alerts_summary(self):
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


alerting_engine = AlertingEngine()
