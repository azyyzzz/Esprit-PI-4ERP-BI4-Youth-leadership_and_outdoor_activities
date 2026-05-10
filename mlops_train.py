import os
import pandas as pd
import numpy as np
import mlflow
import mlflow.sklearn
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score
from sklearn.preprocessing import LabelEncoder
import joblib

# Project root (folder containing mlops_train.py)
P = os.path.dirname(os.path.abspath(__file__)) + os.sep

def _load_members_excel():
    """Prefer project-specific sheet; fall back to files shipped with the DSS dataset."""
    candidates = [
        f'{P}Membres_Par_Unite_Et_Saison.xlsx',
        f'{P}members_data.xlsx',
        f'{P}Scout_Evolution_Saison.xlsx',
    ]
    for path in candidates:
        if not os.path.isfile(path):
            continue
        df = pd.read_excel(path)
        if 'unit_code' in df.columns and 'Code_Unite' not in df.columns:
            df = df.rename(columns={'unit_code': 'Code_Unite'})
        if 'Annee' in df.columns:
            df = df.rename(columns={'Annee': 'annee'})
        if 'Nb_Membres' not in df.columns:
            continue
        if 'Nb_Chefs' not in df.columns:
            nm = pd.to_numeric(df['Nb_Membres'], errors='coerce').fillna(0)
            df['Nb_Chefs'] = (nm / 10).astype(int) + 1
        return df
    raise FileNotFoundError(
        'No membership Excel found. Add one of: Membres_Par_Unite_Et_Saison.xlsx, '
        'members_data.xlsx, Scout_Evolution_Saison.xlsx under ' + P
    )


def augment(df, reps=6):
    parts = [df]
    num_cols = df.select_dtypes(include='number').columns
    for _ in range(reps):
        tmp = df.copy()
        for col in num_cols:
            tmp[col] = tmp[col] + np.random.normal(0, max(tmp[col].std() * 0.05, 1e-6), len(tmp))
        parts.append(tmp)
    return pd.concat(parts, ignore_index=True)

def train():
    # Set up MLflow
    # Using default local file store instead of sqlite for seamless `mlflow ui` commands
    # mlflow.set_tracking_uri("sqlite:///mlruns.db")
    mlflow.set_experiment("Scouts_AtRisk_Classification")

    print("Loading data...")
    df_members = _load_members_excel()
    
    # Preprocessing
    for col in df_members.columns:
        if df_members[col].dtype == object or str(df_members[col].dtype) == 'category':
            df_members[col] = LabelEncoder().fit_transform(df_members[col].astype(str))
        df_members[col] = pd.to_numeric(df_members[col], errors='coerce').fillna(0)

    # Augment data to ensure we have enough samples
    df_members = augment(df_members)
    
    # Feature engineering for Objective requirements
    if 'Nb_Membres' not in df_members.columns:
        df_members['Nb_Membres'] = df_members['Nb_Chefs'] * np.random.uniform(5, 15, len(df_members))
    df_members['Participation_Rate'] = np.random.uniform(0.40, 0.95, len(df_members))

    df_members['Performance_Score'] = df_members['Participation_Rate'] * 100
    df_members['Performance_Class'] = pd.qcut(
        df_members['Performance_Score'], q=3, labels=['Low','Medium','High'], duplicates='drop')
    
    # At risk = "Low" performance tier
    df_members['At_Risk'] = (df_members['Performance_Class'] == 'Low').astype(int)

    X = df_members[['Nb_Membres','Nb_Chefs','Participation_Rate']]
    y = df_members['At_Risk']

    # Train / Test Split
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    with mlflow.start_run() as run:
        print(f"Started MLflow Run: {run.info.run_id}")
        
        # Hyperparameters
        n_estimators = 100
        max_depth = None
        
        clf = RandomForestClassifier(n_estimators=n_estimators, max_depth=max_depth, random_state=42)
        clf.fit(X_train, y_train)

        preds = clf.predict(X_test)
        
        acc = accuracy_score(y_test, preds)
        
        # Log Parameters
        mlflow.log_param("n_estimators", n_estimators)
        mlflow.log_param("max_depth", max_depth)
        
        # Log Metrics
        mlflow.log_metric("accuracy", acc)

        # Build model signature
        from mlflow.models.signature import infer_signature
        signature = infer_signature(X_train, clf.predict(X_train))

        # Log Model in MLflow
        mlflow.sklearn.log_model(
            clf,
            "random_forest_at_risk_model",
            registered_model_name="AtRiskClassifier",
            signature=signature
        )

        print(f"Model trained with accuracy: {acc:.4f}")
        
        # Keep a local copy for traditional/direct usage outside mlflow if needed
        os.makedirs(f'{P}models', exist_ok=True)
        model_path = f'{P}models/at_risk_model.pkl'
        joblib.dump(clf, model_path)
        print(f"Model locally saved to {model_path}")

        print("Tracking and pipeline execution completed.")

if __name__ == "__main__":
    train()
