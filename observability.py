"""
observability.py — Structured logging module for Scouts MLOps monitoring.

Provides:
  - JSON-formatted structured logs
  - Error logging with context (endpoint, input data, stack trace)
  - Anomaly event logging (drift, accuracy drops)
  - Retraining trigger logging
  - Log rotation (10MB max, 5 backups)

Metrics = WHAT happens  →  Prometheus gauges/counters
Logs    = WHY it happens →  This module
"""

import os
import json
import logging
import traceback
from datetime import datetime, timezone
from logging.handlers import RotatingFileHandler

# ---------------------------------------------------------------------------
# Paths
# ---------------------------------------------------------------------------
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
LOG_DIR = os.path.join(BASE_DIR, "logs")
os.makedirs(LOG_DIR, exist_ok=True)

MONITORING_LOG = os.path.join(LOG_DIR, "monitoring.log")
ALERTS_LOG = os.path.join(LOG_DIR, "monitoring_alerts.log")

# ---------------------------------------------------------------------------
# JSON Formatter
# ---------------------------------------------------------------------------
class JSONFormatter(logging.Formatter):
    """Emit each log record as a single JSON line."""

    def format(self, record):
        log_entry = {
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "level": record.levelname,
            "logger": record.name,
            "message": record.getMessage(),
        }
        # Attach extra fields if provided via `extra={"context": {...}}`
        if hasattr(record, "context"):
            log_entry["context"] = record.context
        if record.exc_info and record.exc_info[0] is not None:
            log_entry["exception"] = traceback.format_exception(*record.exc_info)
        return json.dumps(log_entry, default=str)

# ---------------------------------------------------------------------------
# Logger factory
# ---------------------------------------------------------------------------
def _make_logger(name: str, filepath: str) -> logging.Logger:
    logger = logging.getLogger(name)
    if logger.handlers:
        return logger  # already configured
    logger.setLevel(logging.DEBUG)
    handler = RotatingFileHandler(
        filepath, maxBytes=10 * 1024 * 1024, backupCount=5, encoding="utf-8"
    )
    handler.setFormatter(JSONFormatter())
    logger.addHandler(handler)
    # Also log to console for dev convenience
    console = logging.StreamHandler()
    console.setFormatter(JSONFormatter())
    logger.addHandler(console)
    return logger

# Two loggers: one for general monitoring, one for alerts
monitor_logger = _make_logger("scouts.monitoring", MONITORING_LOG)
alert_logger = _make_logger("scouts.alerts", ALERTS_LOG)

# ---------------------------------------------------------------------------
# Public helpers
# ---------------------------------------------------------------------------

def log_request(endpoint: str, method: str, status_code: int, latency_ms: float,
                input_data: dict | None = None):
    """Log every API request."""
    monitor_logger.info(
        "API request",
        extra={"context": {
            "event": "api_request",
            "endpoint": endpoint,
            "method": method,
            "status_code": status_code,
            "latency_ms": round(latency_ms, 2),
            "input_data": input_data,
        }},
    )


def log_prediction(result: str, confidence: float, input_data: dict):
    """Log a model prediction."""
    monitor_logger.info(
        f"Prediction: {result}",
        extra={"context": {
            "event": "prediction",
            "result": result,
            "confidence": round(confidence, 4),
            "input_data": input_data,
        }},
    )


def log_error(endpoint: str, error_msg: str, input_data: dict | None = None,
              exc_info=None):
    """Log an error with full context."""
    monitor_logger.error(
        f"Error on {endpoint}: {error_msg}",
        exc_info=exc_info,
        extra={"context": {
            "event": "error",
            "endpoint": endpoint,
            "input_data": input_data,
        }},
    )


def log_drift(drift_type: str, drift_score: float, details: str):
    """Log a drift or degradation event."""
    monitor_logger.warning(
        f"Drift detected: {drift_type}",
        extra={"context": {
            "event": "drift",
            "drift_type": drift_type,
            "drift_score": round(drift_score, 4),
            "details": details,
        }},
    )


def log_anomaly(anomaly_type: str, details: str, severity: str = "warning"):
    """Log a detected anomaly."""
    level = logging.WARNING if severity == "warning" else logging.CRITICAL
    monitor_logger.log(
        level,
        f"Anomaly: {anomaly_type}",
        extra={"context": {
            "event": "anomaly",
            "anomaly_type": anomaly_type,
            "details": details,
            "severity": severity,
        }},
    )


def log_retraining_trigger(reason: str, current_metric: float, threshold: float):
    """Log when retraining should be triggered."""
    monitor_logger.critical(
        f"Retraining trigger: {reason}",
        extra={"context": {
            "event": "retraining_trigger",
            "reason": reason,
            "current_metric": round(current_metric, 4),
            "threshold": round(threshold, 4),
        }},
    )


def log_alert(alert_name: str, severity: str, message: str):
    """Write alert to the dedicated alerts log."""
    alert_logger.warning(
        f"ALERT [{severity.upper()}] {alert_name}: {message}",
        extra={"context": {
            "event": "alert",
            "alert_name": alert_name,
            "severity": severity,
            "message": message,
        }},
    )
