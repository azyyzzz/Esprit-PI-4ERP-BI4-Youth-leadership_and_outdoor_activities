from dataclasses import dataclass, field
from typing import List, Optional
import numpy as np

TRAINING_BASELINE = {
    "Nb_Membres": {"mean": 25.0, "std": 15.0},
    "Nb_Chefs": {"mean": 4.0, "std": 2.5},
    "Participation_Rate": {"mean": 0.65, "std": 0.15},
}

BASELINE_ACCURACY = 0.92
BASELINE_CONFIDENCE = 0.85
ACCURACY_DROP_THRESHOLD = 0.05
CONFIDENCE_THRESHOLD = 0.70
DRIFT_SCORE_THRESHOLD = 0.30


@dataclass
class DriftAlert:
    alert_type: str
    severity: str
    message: str
    score: float
    threshold: float
    feature: Optional[str] = None


@dataclass
class DriftReport:
    drift_score: float = 0.0
    accuracy: float = BASELINE_ACCURACY
    avg_confidence: float = BASELINE_CONFIDENCE
    alerts: List[DriftAlert] = field(default_factory=list)
    is_drifted: bool = False
    needs_retraining: bool = False


class DriftDetector:
    def __init__(self):
        self.baseline = TRAINING_BASELINE.copy()
        self._recent_inputs = []
        self._recent_confidences = []
        self._simulated_accuracy = BASELINE_ACCURACY
        self._max_history = 200

    def record_prediction(self, input_data: dict, confidence: float):
        self._recent_inputs.append(input_data)
        self._recent_confidences.append(confidence)
        self._recent_inputs = self._recent_inputs[-self._max_history :]
        self._recent_confidences = self._recent_confidences[-self._max_history :]

    def set_accuracy(self, accuracy: float):
        self._simulated_accuracy = accuracy

    def check_drift(self) -> DriftReport:
        report = DriftReport()
        if len(self._recent_inputs) < 5:
            return report

        scores = {}
        for feat, b in self.baseline.items():
            vals = [v.get(feat) for v in self._recent_inputs if feat in v]
            if not vals:
                continue
            deviation = abs(np.mean(vals) - b["mean"]) / max(b["std"], 1e-6)
            scores[feat] = min(deviation / 3.0, 1.0)

        report.drift_score = float(np.mean(list(scores.values()))) if scores else 0.0
        report.accuracy = self._simulated_accuracy
        report.avg_confidence = (
            float(np.mean(self._recent_confidences[-50:])) if self._recent_confidences else BASELINE_CONFIDENCE
        )

        if report.drift_score > DRIFT_SCORE_THRESHOLD:
            report.alerts.append(
                DriftAlert("data_drift", "warning", "Data drift detected", report.drift_score, DRIFT_SCORE_THRESHOLD)
            )
        if (BASELINE_ACCURACY - report.accuracy) > ACCURACY_DROP_THRESHOLD:
            report.alerts.append(
                DriftAlert("accuracy_drop", "critical", "Accuracy degraded", report.accuracy, BASELINE_ACCURACY - ACCURACY_DROP_THRESHOLD)
            )
        if report.avg_confidence < CONFIDENCE_THRESHOLD:
            report.alerts.append(
                DriftAlert("confidence_decrease", "warning", "Confidence below threshold", report.avg_confidence, CONFIDENCE_THRESHOLD)
            )

        report.is_drifted = len(report.alerts) > 0
        report.needs_retraining = any(a.severity == "critical" for a in report.alerts)
        return report

    def get_baselines(self):
        return {
            "accuracy": BASELINE_ACCURACY,
            "confidence": BASELINE_CONFIDENCE,
            "features": self.baseline,
            "drift_threshold": DRIFT_SCORE_THRESHOLD,
            "accuracy_drop_threshold": ACCURACY_DROP_THRESHOLD,
        }


drift_detector = DriftDetector()
