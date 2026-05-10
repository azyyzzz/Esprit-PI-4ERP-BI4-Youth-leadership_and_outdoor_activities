import os
import time
import joblib
import pandas as pd
from contextlib import asynccontextmanager
from fastapi import FastAPI, HTTPException
from fastapi.responses import Response, JSONResponse
from fastapi.exceptions import RequestValidationError
from pydantic import BaseModel
from prometheus_client import Counter, Histogram, Gauge, CollectorRegistry, generate_latest, CONTENT_TYPE_LATEST

from drift_detector import drift_detector, BASELINE_ACCURACY, BASELINE_CONFIDENCE
from alerting import alerting_engine
from observability import log_request, log_prediction, log_error, log_drift, log_retraining_trigger, log_anomaly

REGISTRY = CollectorRegistry()
REQUEST_COUNT = Counter("api_requests_total", "Total API requests", ["endpoint", "method", "status"], registry=REGISTRY)
REQUEST_LATENCY = Histogram("api_request_duration_seconds", "Request latency in seconds", ["endpoint"], registry=REGISTRY)
ERROR_COUNT = Counter("api_errors_total", "Total API errors", ["endpoint", "error_type"], registry=REGISTRY)
PREDICTION_COUNT = Counter("model_predictions_total", "Total model predictions", ["result"], registry=REGISTRY)
MODEL_CONFIDENCE = Gauge("model_confidence", "Latest prediction confidence score", registry=REGISTRY)
MODEL_ACCURACY = Gauge("model_accuracy", "Current model accuracy", registry=REGISTRY)
DATA_FRESHNESS = Gauge("data_freshness_seconds", "Seconds since model was loaded", registry=REGISTRY)
MISSING_VALUES = Gauge("data_missing_values_ratio", "Ratio of missing values in recent input data", registry=REGISTRY)
DRIFT_SCORE = Gauge("data_drift_score", "Current data drift score", registry=REGISTRY)
ACTIVE_ALERTS = Gauge("active_alerts", "Number of active monitoring alerts", registry=REGISTRY)
MODEL_ACCURACY.set(BASELINE_ACCURACY)
MODEL_CONFIDENCE.set(BASELINE_CONFIDENCE)

BASE_DIR = os.environ.get("SCOUTS_BASE_DIR", os.path.dirname(os.path.abspath(__file__)))
model_path = os.path.join(BASE_DIR, "models", "at_risk_model.pkl")
model = None
model_load_time = 0.0


@asynccontextmanager
async def lifespan(app: FastAPI):
    global model, model_load_time
    if os.path.exists(model_path):
        model = joblib.load(model_path)
        model_load_time = time.time()
        print(f"[OK] Model loaded from {model_path}")
    else:
        print(f"[WARN] Model not found at {model_path}")
    yield


app = FastAPI(title="Scouts ML API — Monitored", lifespan=lifespan)


@app.exception_handler(RequestValidationError)
async def validation_exception_handler(request, exc):
    endpoint = request.url.path
    ERROR_COUNT.labels(endpoint=endpoint, error_type="validation_error").inc()
    REQUEST_COUNT.labels(endpoint=endpoint, method=request.method, status="422").inc()
    alerting_engine.record_request(0, is_error=True)
    alerting_engine.evaluate()
    ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
    return JSONResponse(status_code=422, content={"detail": exc.errors(), "body": exc.body})


class PredictionRequest(BaseModel):
    Nb_Membres: float
    Nb_Chefs: float
    Participation_Rate: float


@app.post("/predict")
def predict(data: PredictionRequest):
    start = time.time()
    endpoint = "/predict"
    try:
        if model is None:
            ERROR_COUNT.labels(endpoint=endpoint, error_type="model_not_loaded").inc()
            raise HTTPException(status_code=500, detail="Model is not loaded. Train the model first.")

        payload = {"Nb_Membres": data.Nb_Membres, "Nb_Chefs": data.Nb_Chefs, "Participation_Rate": data.Participation_Rate}
        input_df = pd.DataFrame([payload])
        MISSING_VALUES.set(float(input_df.isnull().sum().sum() / input_df.size))

        prediction = model.predict(input_df)[0]
        is_at_risk = bool(prediction == 1)
        result_label = "at_risk" if is_at_risk else "not_at_risk"
        confidence = 0.85
        if hasattr(model, "predict_proba"):
            confidence = float(max(model.predict_proba(input_df)[0]))

        PREDICTION_COUNT.labels(result=result_label).inc()
        MODEL_CONFIDENCE.set(confidence)
        drift_detector.record_prediction(payload, confidence)
        report = drift_detector.check_drift()
        DRIFT_SCORE.set(report.drift_score)
        MODEL_ACCURACY.set(report.accuracy)
        alerting_engine.record_request((time.time() - start) * 1000, is_error=False)
        alerting_engine.update_accuracy(report.accuracy)
        alerting_engine.update_drift_score(report.drift_score)
        alerting_engine.evaluate()
        ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())

        for a in report.alerts:
            log_drift(a.alert_type, a.score, a.message)
            if report.needs_retraining:
                log_retraining_trigger(a.alert_type, a.score, a.threshold)

        if model_load_time > 0:
            DATA_FRESHNESS.set(time.time() - model_load_time)

        elapsed = time.time() - start
        REQUEST_COUNT.labels(endpoint=endpoint, method="POST", status="200").inc()
        REQUEST_LATENCY.labels(endpoint=endpoint).observe(elapsed)
        log_request(endpoint, "POST", 200, elapsed * 1000, payload)
        log_prediction(result_label, confidence, payload)
        return {"At_Risk": is_at_risk, "Message": "Unit is at risk" if is_at_risk else "Unit is not at risk", "Confidence": round(confidence, 4), "Drift_Score": round(report.drift_score, 4), "Input_Data": payload}
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
    status_code = 200 if model is not None else 503
    REQUEST_COUNT.labels(endpoint="/health", method="GET", status=str(status_code)).inc()
    if status_code == 503:
        raise HTTPException(status_code=503, detail={"status": "unhealthy", "model_loaded": False})
    return {"status": "healthy", "model_loaded": True}


@app.get("/metrics")
def metrics():
    return Response(content=generate_latest(REGISTRY), media_type=CONTENT_TYPE_LATEST)


@app.get("/drift")
def get_drift():
    report = drift_detector.check_drift()
    return {
        "drift_score": round(report.drift_score, 4),
        "accuracy": round(report.accuracy, 4),
        "avg_confidence": round(report.avg_confidence, 4),
        "is_drifted": report.is_drifted,
        "needs_retraining": report.needs_retraining,
        "alerts": [{"type": a.alert_type, "severity": a.severity, "message": a.message, "score": round(a.score, 4), "threshold": round(a.threshold, 4)} for a in report.alerts],
    }


@app.get("/alerts")
def get_alerts():
    return {"active_count": alerting_engine.get_active_alert_count(), "alerts": alerting_engine.get_active_alerts_summary()}


@app.get("/baselines")
def get_baselines():
    return drift_detector.get_baselines()


@app.post("/simulate/degrade_accuracy")
def simulate_degrade_accuracy():
    new_acc = BASELINE_ACCURACY - 0.08
    drift_detector.set_accuracy(new_acc)
    alerting_engine.update_accuracy(new_acc)
    MODEL_ACCURACY.set(new_acc)
    alerting_engine.evaluate()
    ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
    log_anomaly("simulated_accuracy_drop", f"Accuracy set to {new_acc:.2%}", "critical")
    return {"message": f"Accuracy degraded to {new_acc:.2%}", "baseline": BASELINE_ACCURACY}


@app.post("/simulate/restore_accuracy")
def simulate_restore_accuracy():
    drift_detector.set_accuracy(BASELINE_ACCURACY)
    alerting_engine.update_accuracy(BASELINE_ACCURACY)
    MODEL_ACCURACY.set(BASELINE_ACCURACY)
    alerting_engine.evaluate()
    ACTIVE_ALERTS.set(alerting_engine.get_active_alert_count())
    return {"message": f"Accuracy restored to {BASELINE_ACCURACY:.2%}"}


if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8005)
