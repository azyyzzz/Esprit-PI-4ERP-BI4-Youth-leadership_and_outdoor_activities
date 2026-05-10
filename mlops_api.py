"""
mlops_api.py — Scouts ML API with Prometheus monitoring.

Metrics exposed:
  - api_requests_total          (Counter)  — by endpoint, method, status
  - api_request_duration_seconds(Histogram)— per-request latency
  - api_errors_total            (Counter)  — 4xx/5xx errors
  - model_predictions_total     (Counter)  — by result label
  - model_confidence            (Gauge)    — latest prediction confidence
  - model_accuracy              (Gauge)    — current accuracy vs baseline
  - data_freshness_seconds      (Gauge)    — seconds since model load
  - data_missing_values_ratio   (Gauge)    — % missing in incoming data
  - data_drift_score            (Gauge)    — distribution shift metric
  - active_alerts               (Gauge)    — number of active alerts

Endpoints:
  POST /predict        — run model inference
  GET  /health         — liveness check
  GET  /metrics        — Prometheus scrape target
  GET  /drift          — current drift report
  GET  /alerts         — current active alerts
  GET  /baselines      — baseline values
"""

import os
import time
import numpy as np
import joblib
import pandas as pd
from contextlib import asynccontextmanager
from fastapi import FastAPI, HTTPException, Request
from fastapi.responses import Response
from pydantic import BaseModel
from fastapi.exceptions import RequestValidationError
from fastapi.responses import JSONResponse

# Prometheus client
from prometheus_client import (
    Counter, Histogram, Gauge, CollectorRegistry, generate_latest, CONTENT_TYPE_LATEST
)

# Internal modules
from drift_detector import drift_detector, BASELINE_ACCURACY, BASELINE_CONFIDENCE
from alerting import alerting_engine
from observability import (
    log_request, log_prediction, log_error,
    log_drift, log_anomaly, log_retraining_trigger
)

# ===========================================================================
# Prometheus metrics (custom registry to avoid conflicts)
# ===========================================================================
REGISTRY = CollectorRegistry()

REQUEST_COUNT = Counter(
    "api_requests_total",
    "Total API requests",
    ["endpoint", "method", "status"],
    registry=REGISTRY,
)
REQUEST_LATENCY = Histogram(
    "api_request_duration_seconds",
    "Request latency in seconds",
    ["endpoint"],
    buckets=[0.01, 0.025, 0.05, 0.1, 0.25, 0.5, 1.0, 2.5, 5.0],
    registry=REGISTRY,
)
ERROR_COUNT = Counter(
    "api_errors_total",
    "Total API errors",
    ["endpoint", "error_type"],
    registry=REGISTRY,
)
PREDICTION_COUNT = Counter(
    "model_predictions_total",
    "Total model predictions",
    ["result"],
    registry=REGISTRY,
)
MODEL_CONFIDENCE = Gauge(
    "model_confidence",
    "Latest prediction confidence score",
    registry=REGISTRY,
)
MODEL_ACCURACY = Gauge(
    "model_accuracy",
    "Current model accuracy",
    registry=REGISTRY,
)
DATA_FRESHNESS = Gauge(
    "data_freshness_seconds",
    "Seconds since model was loaded",
    registry=REGISTRY,
)
MISSING_VALUES = Gauge(
    "data_missing_values_ratio",
    "Ratio of missing values in recent input data",
    registry=REGISTRY,
)
DRIFT_SCORE = Gauge(
    "data_drift_score",
    "Current data drift score (0=no drift, 1=full drift)",
    registry=REGISTRY,
)
ACTIVE_ALERTS = Gauge(
    "active_alerts",
    "Number of currently active monitoring alerts",
    registry=REGISTRY,
)

# Initialize accuracy gauge to baseline
MODEL_ACCURACY.set(BASELINE_ACCURACY)
MODEL_CONFIDENCE.set(BASELINE_CONFIDENCE)

# ===========================================================================
# Application state
# ===========================================================================
BASE_DIR = os.environ.get(
    "SCOUTS_BASE_DIR",
    "c:/Users/MSI/Desktop/wetransfer_scouts_2026-02-28_1339/Scouts/",
)
if not os.path.exists(BASE_DIR):
    BASE_DIR = "/app/"  # Docker fallback

model_path = os.path.join(BASE_DIR, "models", "at_risk_model.pkl")
model = None
model_load_time: float = 0.0  # epoch seconds


# ===========================================================================
# Lifespan (startup / shutdown)
# ===========================================================================
@asynccontextmanager
async def lifespan(app: FastAPI):
    # Startup
    global model, model_load_time
    if os.path.exists(model_path):
        model = joblib.load(model_path)
        model_load_time = time.time()
        print(f"[OK] Model loaded from {model_path}")
    else:
        print(f"[WARN] Model not found at {model_path}")
    yield
    # Shutdown (nothing needed)


app = FastAPI(title="Scouts ML API — Monitored", lifespan=lifespan)


@app.exception_handler(RequestValidationError)
async def validation_exception_handler(request: Request, exc: RequestValidationError):
    endpoint = request.url.path
    ERROR_COUNT.labels(endpoint=endpoint, error_type="validation_error").inc()
    REQUEST_COUNT.labels(endpoint=endpoint, method=request.method, status="422").inc()
    
    alerting_engine.record_request(0, is_error=True)
    alerting_engine.evaluate()
    ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
    
    return JSONResponse(
        status_code=422,
        content={"detail": exc.errors(), "body": exc.body},
    )


# ===========================================================================
# Request model
# ===========================================================================
class PredictionRequest(BaseModel):
    Nb_Membres: float
    Nb_Chefs: float
    Participation_Rate: float


# ===========================================================================
# Endpoints
# ===========================================================================

@app.post("/predict")
def predict(data: PredictionRequest, request: Request):
    start = time.time()
    endpoint = "/predict"
    try:
        if model is None:
            ERROR_COUNT.labels(endpoint=endpoint, error_type="model_not_loaded").inc()
            log_error(endpoint, "Model not loaded")
            raise HTTPException(status_code=500, detail="Model is not loaded. Train the model first.")

        # Build input
        input_dict = {
            "Nb_Membres": data.Nb_Membres,
            "Nb_Chefs": data.Nb_Chefs,
            "Participation_Rate": data.Participation_Rate,
        }
        input_df = pd.DataFrame([input_dict])

        # Check for missing / NaN values
        missing_ratio = float(input_df.isnull().sum().sum() / input_df.size)
        MISSING_VALUES.set(missing_ratio)

        # Predict
        prediction = model.predict(input_df)[0]
        is_at_risk = bool(prediction == 1)
        result_label = "at_risk" if is_at_risk else "not_at_risk"

        # Simulate confidence using predict_proba if available
        confidence = 0.85
        if hasattr(model, "predict_proba"):
            proba = model.predict_proba(input_df)[0]
            confidence = float(max(proba))

        # Record metrics
        PREDICTION_COUNT.labels(result=result_label).inc()
        MODEL_CONFIDENCE.set(confidence)

        # Record for drift detection
        drift_detector.record_prediction(input_dict, confidence)

        # Check drift
        drift_report = drift_detector.check_drift()
        DRIFT_SCORE.set(drift_report.drift_score)
        MODEL_ACCURACY.set(drift_report.accuracy)

        # Feed alerting engine
        latency_ms = (time.time() - start) * 1000
        alerting_engine.record_request(latency_ms, is_error=False)
        alerting_engine.update_accuracy(drift_report.accuracy)
        alerting_engine.update_drift_score(drift_report.drift_score)
        new_alerts = alerting_engine.evaluate()
        ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())

        # Log drift alerts
        for alert in drift_report.alerts:
            log_drift(alert.alert_type, alert.score, alert.message)
            if drift_report.needs_retraining:
                log_retraining_trigger(alert.alert_type, alert.score, alert.threshold)

        # Update data freshness
        if model_load_time > 0:
            DATA_FRESHNESS.set(time.time() - model_load_time)

        # Log
        log_prediction(result_label, confidence, input_dict)

        elapsed = time.time() - start
        REQUEST_COUNT.labels(endpoint=endpoint, method="POST", status="200").inc()
        REQUEST_LATENCY.labels(endpoint=endpoint).observe(elapsed)
        log_request(endpoint, "POST", 200, elapsed * 1000, input_dict)

        return {
            "At_Risk": is_at_risk,
            "Message": "Unit is at risk" if is_at_risk else "Unit is not at risk",
            "Confidence": round(confidence, 4),
            "Drift_Score": round(drift_report.drift_score, 4),
            "Input_Data": input_dict,
        }

    except HTTPException:
        elapsed = time.time() - start
        REQUEST_COUNT.labels(endpoint=endpoint, method="POST", status="500").inc()
        REQUEST_LATENCY.labels(endpoint=endpoint).observe(elapsed)
        raise
    except Exception as e:
        elapsed = time.time() - start
        ERROR_COUNT.labels(endpoint=endpoint, error_type="unhandled").inc()
        REQUEST_COUNT.labels(endpoint=endpoint, method="POST", status="500").inc()
        REQUEST_LATENCY.labels(endpoint=endpoint).observe(elapsed)
        alerting_engine.record_request(elapsed * 1000, is_error=True)
        alerting_engine.evaluate()
        ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
        log_error(endpoint, str(e), exc_info=True)
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/health")
def health():
    start = time.time()
    status_code = 200 if model is not None else 503
    result = {
        "status": "healthy" if model is not None else "unhealthy",
        "model_loaded": model is not None,
        "uptime_seconds": round(time.time() - model_load_time, 1) if model_load_time > 0 else 0,
    }
    elapsed = time.time() - start
    REQUEST_COUNT.labels(endpoint="/health", method="GET", status=str(status_code)).inc()
    REQUEST_LATENCY.labels(endpoint="/health").observe(elapsed)
    if status_code == 503:
        raise HTTPException(status_code=503, detail=result)
    return result


@app.get("/metrics")
def metrics():
    """Prometheus scrape endpoint."""
    return Response(
        content=generate_latest(REGISTRY),
        media_type=CONTENT_TYPE_LATEST,
    )


@app.get("/drift")
def get_drift():
    """Return current drift report."""
    report = drift_detector.check_drift()
    return {
        "drift_score": round(report.drift_score, 4),
        "accuracy": round(report.accuracy, 4),
        "avg_confidence": round(report.avg_confidence, 4),
        "is_drifted": report.is_drifted,
        "needs_retraining": report.needs_retraining,
        "alerts": [
            {
                "type": a.alert_type,
                "severity": a.severity,
                "message": a.message,
                "score": round(a.score, 4),
                "threshold": round(a.threshold, 4),
            }
            for a in report.alerts
        ],
    }


@app.get("/alerts")
def get_alerts():
    """Return currently active alerts."""
    return {
        "active_count": alerting_engine.get_active_alert_count(),
        "alerts": alerting_engine.get_active_alerts_summary(),
    }


@app.get("/baselines")
def get_baselines():
    """Return baseline values for comparison."""
    return drift_detector.get_baselines()


# ===========================================================================
# Simulation helper endpoints (used by simulate_scenarios.py)
# ===========================================================================

@app.post("/simulate/degrade_accuracy")
def simulate_degrade_accuracy():
    """Simulate accuracy degradation (for testing alerts)."""
    new_acc = BASELINE_ACCURACY - 0.08  # 8% drop
    drift_detector.set_accuracy(new_acc)
    alerting_engine.update_accuracy(new_acc)
    MODEL_ACCURACY.set(new_acc)
    alerting_engine.evaluate()
    ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
    log_anomaly("simulated_accuracy_drop", f"Accuracy set to {new_acc:.2%}", "critical")
    return {"message": f"Accuracy degraded to {new_acc:.2%}", "baseline": BASELINE_ACCURACY}


@app.post("/simulate/restore_accuracy")
def simulate_restore_accuracy():
    """Restore accuracy to baseline."""
    drift_detector.set_accuracy(BASELINE_ACCURACY)
    alerting_engine.update_accuracy(BASELINE_ACCURACY)
    MODEL_ACCURACY.set(BASELINE_ACCURACY)
    alerting_engine.evaluate()
    ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
    return {"message": f"Accuracy restored to {BASELINE_ACCURACY:.2%}"}


# ===========================================================================
# Main
# ===========================================================================
if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8005)
