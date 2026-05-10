# ⚜️ Scout ML Dashboard: Academic Plot Interpretations

This guide provides a professional description of every visualization in the Scout Machine Learning Academic Report. It is designed to help instructors and practitioners understand the underlying models, metrics, and business value of each plot.

---

## 📈 Section 1: The 8 Dashboard Objectives

### Objective 1: Membership Forecasting (ARIMA vs Lag-Linear)
*   **Description:** This plot compares a statistical Time Series model (ARIMA) against a feature-driven Lag model. 
*   **Interpretation:** Smaller bars represent higher precision (lower RMSE). The model utilizes past season membership counts and leader availability to predict future growth. An RMSE of ~1.8-3.4 implies we are predicting unit sizes within 2-4 members of accuracy.

### Objective 2: Participation Prediction (Random Forest vs Ridge)
*   **Description:** A classic regression comparison predicting the percentage of scouts attending activities. 
*   **Interpretation:** Random Forest captures non-linear trends (e.g., specific units consistently over-performing), while Ridge provides a stable linear baseline. Low RMSE/MAE indicates high reliability in predicting engagement.

### Objective 3: Budget Estimation (Random Forest vs Linear)
*   **Description:** Estimates the required financial resources for each unit based on member count and planned intensity.
*   **Interpretation:** This model justifies financial allocation. The comparison helps identify if a simple linear rule suffices or if complex unit interactions (RF) are necessary for fair budgeting.

### Objective 4: Anomaly Detection (Isolation Forest vs LOF)
*   **Description:** Identifies "outlier" units that show unusual patterns in membership vs. budget ratios.
*   **Interpretation:** The score represents the percentage of units flagged as anomalies. High scores might indicate potential data entry errors or units requiring immediate management attention.

### Objective 5: Unit Performance (Classification)
*   **Description:** Categorizes units into "Low", "Medium", and "High" performance tiers using Accuracy and F1-score.
*   **Interpretation:** The bars show which model (Logistic Regression vs. Random Forest) is better at distinguishing between tiers. High ROC-AUC reflects the model's "confidence" in its ranking.

### Objective 6: At-Risk Units (Risk Classification)
*   **Description:** Specifically targets the "Low Engagement" units to predict which ones are at risk of declining further.
*   **Interpretation:** This is an early warning system. Higher bars in F1-Score indicate we can pinpoint struggling units with fewer "false alarms."

### Objective 7: Behavioral Segmentation (K-Means vs Agglomerative)
*   **Description:** Groups units into clusters based on their internal similarities (not just performance).
*   **Interpretation:** Silhouette Score measures how "tight" the groups are. A higher score means the units in a cluster are very similar to each other and distinct from other clusters.

### Objective 8: Engagement Scoring (Ridge vs SVR)
*   **Description:** Regression of the unit's engagement score calculated from multi-variable heuristics.
*   **Interpretation:** This plot validates if the mathematical engagement score is predictable from raw data (Budget, Leaders, Members).

---

## 🔬 Section 2: Academic Diagnostics (Grid A-F)

### Regression: Actual vs Predicted & Residuals
*   **Actual vs Predicted:** A perfect diagonal line would mean 100% accuracy. Scatter points clustered near the line indicate high model reliability.
*   **Residuals:** Shows the "errors" (Actual - Predicted). Ideally, these points should be randomly scattered around zero. If they form a "funnel" shape, it suggests the model needs better handling of outliers.

### Clustering: Profiles & PCA Projection
*   **Cluster Profiles:** Displays the average Member/Budget/Participation for each discovered group. It helps define "who" Cluster 0 or Cluster 1 represents (e.g., "The Large Rural Units").
*   **PCA 2D Projection:** Since units have many dimensions, PCA flattens them to 2D. It visually confirms if K-Means has successfully "separated" the different types of units.

### Classification: ROC Curve & Confusion Matrices
*   **ROC Curve:** The further the curve is from the diagonal center line, the better the model is. The area under the curve (AUC) quantifies this "skill."
*   **Confusion Matrix:** A grid showing "Matches" and "Mismatches." It tells the teacher exactly where the model is confused (e.g., "It often mistakes Medium units for High ones").

### Feature Importance (Cls & Reg)
*   **Interpretation:** Lists which variables have the most influence on the scout results. For example, if "Nb_Chefs" (Leader count) is top, it proves to the teacher that leader quality is the primary driver of scout membership.

### K-Means Elbow Method
*   **Interpretation:** Shows the "Inertia" (unexplained variance). The point where the curve "bends" (the elbow) is the mathematically optimal number of clusters for the Scout units.
