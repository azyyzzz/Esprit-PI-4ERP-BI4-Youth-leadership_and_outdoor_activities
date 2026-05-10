import json
import logging
import os
import traceback
from datetime import datetime, timezone
from logging.handlers import RotatingFileHandler

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
LOG_DIR = os.path.join(BASE_DIR, "logs")
os.makedirs(LOG_DIR, exist_ok=True)


class JSONFormatter(logging.Formatter):
    def format(self, record):
        out = {
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "level": record.levelname,
            "logger": record.name,
            "message": record.getMessage(),
        }
        if hasattr(record, "context"):
            out["context"] = record.context
        if record.exc_info and record.exc_info[0] is not None:
            out["exception"] = traceback.format_exception(*record.exc_info)
        return json.dumps(out, default=str)


def _mk_logger(name, filepath):
    logger = logging.getLogger(name)
    if logger.handlers:
        return logger
    logger.setLevel(logging.DEBUG)
    h = RotatingFileHandler(filepath, maxBytes=10 * 1024 * 1024, backupCount=5, encoding="utf-8")
    h.setFormatter(JSONFormatter())
    logger.addHandler(h)
    c = logging.StreamHandler()
    c.setFormatter(JSONFormatter())
    logger.addHandler(c)
    return logger


monitor_logger = _mk_logger("scouts.monitoring", os.path.join(LOG_DIR, "monitoring.log"))
alert_logger = _mk_logger("scouts.alerts", os.path.join(LOG_DIR, "monitoring_alerts.log"))


def log_request(endpoint, method, status_code, latency_ms, input_data=None):
    monitor_logger.info("API request", extra={"context": {
        "event": "api_request", "endpoint": endpoint, "method": method,
        "status_code": status_code, "latency_ms": round(latency_ms, 2), "input_data": input_data
    }})


def log_prediction(result, confidence, input_data):
    monitor_logger.info("Prediction", extra={"context": {
        "event": "prediction", "result": result, "confidence": round(confidence, 4), "input_data": input_data
    }})


def log_error(endpoint, error_msg, input_data=None, exc_info=None):
    monitor_logger.error(f"Error on {endpoint}: {error_msg}", exc_info=exc_info, extra={"context": {
        "event": "error", "endpoint": endpoint, "input_data": input_data
    }})


def log_drift(drift_type, drift_score, details):
    monitor_logger.warning("Drift detected", extra={"context": {
        "event": "drift", "drift_type": drift_type, "drift_score": round(drift_score, 4), "details": details
    }})


def log_anomaly(anomaly_type, details, severity="warning"):
    level = logging.WARNING if severity == "warning" else logging.CRITICAL
    monitor_logger.log(level, "Anomaly", extra={"context": {
        "event": "anomaly", "anomaly_type": anomaly_type, "details": details, "severity": severity
    }})


def log_retraining_trigger(reason, current_metric, threshold):
    monitor_logger.critical("Retraining trigger", extra={"context": {
        "event": "retraining_trigger", "reason": reason,
        "current_metric": round(current_metric, 4), "threshold": round(threshold, 4)
    }})


def log_alert(alert_name, severity, message):
    alert_logger.warning(f"ALERT [{severity.upper()}] {alert_name}: {message}", extra={"context": {
        "event": "alert", "alert_name": alert_name, "severity": severity, "message": message
    }})
