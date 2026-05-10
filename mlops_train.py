import os
import joblib
import mlflow
import mlflow.sklearn
import numpy as np
import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from mlflow.models.signature import infer_signature

P = os.path.dirname(os.path.abspath(__file__)) + os.sep


def _load_members_excel():
    candidates = [
        f"{P}Membres_Par_Unite_Et_Saison.xlsx",
        f"{P}members_data.xlsx",
        f"{P}Scout_Evolution_Saison.xlsx",
        f"{P}ml_app{os.sep}members_data.xlsx",
        f"{P}ml_app{os.sep}Scout_Evolution_Saison.xlsx",
    ]
    for path in candidates:
        if os.path.isfile(path):
            df = pd.read_excel(path)
            if "unit_code" in df.columns and "Code_Unite" not in df.columns:
                df = df.rename(columns={"unit_code": "Code_Unite"})
            if "Annee" in df.columns:
                df = df.rename(columns={"Annee": "annee"})
            if "Nb_Membres" in df.columns:
                if "Nb_Chefs" not in df.columns:
                    nm = pd.to_numeric(df["Nb_Membres"], errors="coerce").fillna(0)
                    df["Nb_Chefs"] = (nm / 10).astype(int) + 1
                return df
    raise FileNotFoundError("Membership Excel not found.")


def augment(df, reps=6):
    parts = [df]
    num_cols = df.select_dtypes(include="number").columns
    for _ in range(reps):
        tmp = df.copy()
        for col in num_cols:
            tmp[col] = tmp[col] + np.random.normal(0, max(tmp[col].std() * 0.05, 1e-6), len(tmp))
        parts.append(tmp)
    return pd.concat(parts, ignore_index=True)


def train():
    mlflow.set_experiment("Scouts_AtRisk_Classification")
    df = _load_members_excel()
    for col in df.columns:
        if str(df[col].dtype) == "object":
            df[col] = LabelEncoder().fit_transform(df[col].astype(str))
        df[col] = pd.to_numeric(df[col], errors="coerce").fillna(0)

    df = augment(df)
    if "Nb_Membres" not in df.columns:
        df["Nb_Membres"] = df["Nb_Chefs"] * np.random.uniform(5, 15, len(df))
    df["Participation_Rate"] = np.random.uniform(0.40, 0.95, len(df))
    df["Performance_Score"] = df["Participation_Rate"] * 100
    df["At_Risk"] = (pd.qcut(df["Performance_Score"], q=3, labels=["Low", "Medium", "High"], duplicates="drop") == "Low").astype(int)

    X = df[["Nb_Membres", "Nb_Chefs", "Participation_Rate"]]
    y = df["At_Risk"]
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    with mlflow.start_run():
        clf = RandomForestClassifier(n_estimators=100, random_state=42)
        clf.fit(X_train, y_train)
        acc = accuracy_score(y_test, clf.predict(X_test))
        mlflow.log_param("n_estimators", 100)
        mlflow.log_metric("accuracy", acc)
        mlflow.sklearn.log_model(
            clf,
            "random_forest_at_risk_model",
            registered_model_name="AtRiskClassifier",
            signature=infer_signature(X_train, clf.predict(X_train)),
        )
        os.makedirs(f"{P}models", exist_ok=True)
        joblib.dump(clf, f"{P}models{os.sep}at_risk_model.pkl")
        print(f"Model trained. Accuracy={acc:.4f}")


if __name__ == "__main__":
    train()
