"""
drift_detector.py — Data & model drift detection for Scouts MLOps.

Detects:
  1. Data distribution shift (Z-score deviation from training baseline)
  2. Accuracy drop (>5% below baseline)
  3. Confidence decrease (below threshold)

Baseline values are derived from the training data statistics.
"""

import numpy as np
from dataclasses import dataclass, field
from typing import List, Optional

# ---------------------------------------------------------------------------
# Baseline configuration (from training data in mlops_train.py)
# ---------------------------------------------------------------------------
# These are the expected distributions of the 3 input features at training time.
# They will be used to detect data drift at inference time.

TRAINING_BASELINE = {
    "Nb_Membres": {"mean": 25.0, "std": 15.0, "min": 1.0, "max": 80.0},
    "Nb_Chefs":   {"mean": 4.0,  "std": 2.5,  "min": 1.0, "max": 15.0},
    "Participation_Rate": {"mean": 0.65, "std": 0.15, "min": 0.10, "max": 0.95},
}

# Model performance baselines
BASELINE_ACCURACY = 0.92      # accuracy from initial training
BASELINE_CONFIDENCE = 0.85    # average prediction confidence
ACCURACY_DROP_THRESHOLD = 0.05  # 5% drop triggers alert
CONFIDENCE_THRESHOLD = 0.70     # below this = degradation
DRIFT_SCORE_THRESHOLD = 0.30    # above this = significant drift


@dataclass
class DriftAlert:
    alert_type: str        # "data_drift", "accuracy_drop", "confidence_decrease"
    severity: str          # "warning", "critical"
    message: str
    score: float           # numeric value of the metric
    threshold: float       # threshold that was exceeded
    feature: Optional[str] = None  # which feature drifted (for data drift)


@dataclass
class DriftReport:
    """Summary of all drift checks for a batch of predictions."""
    drift_score: float = 0.0
    accuracy: float = BASELINE_ACCURACY
    avg_confidence: float = BASELINE_CONFIDENCE
    alerts: List[DriftAlert] = field(default_factory=list)
    is_drifted: bool = False
    needs_retraining: bool = False


class DriftDetector:
    """Stateful drift detector that accumulates prediction history."""

    def __init__(self):
        self.baseline = TRAINING_BASELINE.copy()
        self.baseline_accuracy = BASELINE_ACCURACY
        self.baseline_confidence = BASELINE_CONFIDENCE

        # Rolling window of recent predictions for accuracy estimation
        self._recent_inputs: list = []       # list of dicts
        self._recent_confidences: list = []  # list of floats
        self._simulated_accuracy: float = BASELINE_ACCURACY
        self._max_history = 200

    # ------------------------------------------------------------------
    # Public API
    # ------------------------------------------------------------------

    def record_prediction(self, input_data: dict, confidence: float):
        """Record a single prediction for drift tracking."""
        self._recent_inputs.append(input_data)
        self._recent_confidences.append(confidence)
        # Trim to window
        if len(self._recent_inputs) > self._max_history:
            self._recent_inputs = self._recent_inputs[-self._max_history:]
            self._recent_confidences = self._recent_confidences[-self._max_history:]

    def set_accuracy(self, accuracy: float):
        """Update the current measured accuracy (e.g. from periodic eval)."""
        self._simulated_accuracy = accuracy

    def check_drift(self) -> DriftReport:
        """Run all drift checks and return a consolidated report."""
        report = DriftReport()

        if len(self._recent_inputs) < 5:
            return report  # not enough data yet

        # 1. Data distribution drift
        feature_drifts = self._check_data_drift()
        report.drift_score = np.mean(list(feature_drifts.values())) if feature_drifts else 0.0

        for feat_name, z_score in feature_drifts.items():
            if z_score > DRIFT_SCORE_THRESHOLD:
                severity = "critical" if z_score > 0.6 else "warning"
                report.alerts.append(DriftAlert(
                    alert_type="data_drift",
                    severity=severity,
                    message=f"Feature '{feat_name}' distribution shifted (Z-deviation={z_score:.3f})",
                    score=z_score,
                    threshold=DRIFT_SCORE_THRESHOLD,
                    feature=feat_name,
                ))

        # 2. Accuracy drop
        report.accuracy = self._simulated_accuracy
        acc_drop = self.baseline_accuracy - self._simulated_accuracy
        if acc_drop > ACCURACY_DROP_THRESHOLD:
            severity = "critical" if acc_drop > 0.10 else "warning"
            report.alerts.append(DriftAlert(
                alert_type="accuracy_drop",
                severity=severity,
                message=f"Accuracy dropped {acc_drop:.1%} below baseline ({self._simulated_accuracy:.2%} vs {self.baseline_accuracy:.2%})",
                score=self._simulated_accuracy,
                threshold=self.baseline_accuracy - ACCURACY_DROP_THRESHOLD,
            ))

        # 3. Confidence decrease
        if self._recent_confidences:
            report.avg_confidence = float(np.mean(self._recent_confidences[-50:]))
            if report.avg_confidence < CONFIDENCE_THRESHOLD:
                report.alerts.append(DriftAlert(
                    alert_type="confidence_decrease",
                    severity="warning",
                    message=f"Average confidence {report.avg_confidence:.2%} below threshold {CONFIDENCE_THRESHOLD:.2%}",
                    score=report.avg_confidence,
                    threshold=CONFIDENCE_THRESHOLD,
                ))

        # Summary flags
        report.is_drifted = len(report.alerts) > 0
        report.needs_retraining = any(a.severity == "critical" for a in report.alerts)

        return report

    def get_baselines(self) -> dict:
        """Return the baseline values for display / comparison."""
        return {
            "accuracy": self.baseline_accuracy,
            "confidence": self.baseline_confidence,
            "features": self.baseline,
            "drift_threshold": DRIFT_SCORE_THRESHOLD,
            "accuracy_drop_threshold": ACCURACY_DROP_THRESHOLD,
        }

    # ------------------------------------------------------------------
    # Internal
    # ------------------------------------------------------------------

    def _check_data_drift(self) -> dict:
        """Compute Z-score deviation for each feature vs training baseline."""
        drifts = {}
        for feat_name, baseline in self.baseline.items():
            values = [inp.get(feat_name, None) for inp in self._recent_inputs]
            values = [v for v in values if v is not None]
            if not values:
                continue
            current_mean = np.mean(values)
            # Normalized deviation: |current_mean - baseline_mean| / baseline_std
            deviation = abs(current_mean - baseline["mean"]) / max(baseline["std"], 1e-6)
            # Normalize to 0-1 range using sigmoid-like scaling
            drift_score = min(deviation / 3.0, 1.0)
            drifts[feat_name] = round(drift_score, 4)
        return drifts


# ---------------------------------------------------------------------------
# Singleton instance
# ---------------------------------------------------------------------------
drift_detector = DriftDetector()
