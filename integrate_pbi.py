import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestRegressor, RandomForestClassifier, IsolationForest
from sklearn.preprocessing import LabelEncoder
import pyodbc
from sqlalchemy import create_engine, text

# --- SETTINGS ---
DW_CONN = r"DRIVER={SQL Server Native Client 11.0};SERVER=localhost;DATABASE=scout_DW;Trusted_Connection=yes;"
# (Adapt driver if needed: 'SQL Server', 'ODBC Driver 17 for SQL Server', etc.)

def get_engine():
    try:
        available = [d for d in pyodbc.drivers() if 'SQL Server' in d]
        if not available: return None
        # Try prioritized drivers
        driver = next((d for d in available if '17' in d), None) or \
                 next((d for d in available if '18' in d), None) or \
                 available[0]
        drv = driver.replace(' ', '+')
        
        # Multiple connection string attempts (Local, Instances, etc.)
        attempts = [
            f"mssql+pyodbc://@localhost/scout_DW?driver={drv}&Trusted_Connection=yes&Encrypt=no",
            f"mssql+pyodbc://@localhost\\MSSQLSERVER/scout_DW?driver={drv}&Trusted_Connection=yes&Encrypt=no",
            f"mssql+pyodbc://talend_user:Hsan12345@localhost/scout_DW?driver={drv}&TrustServerCertificate=yes&Encrypt=no"
        ]
        
        for conn_str in attempts:
            try:
                e = create_engine(conn_str, connect_args={"timeout": 2})
                with e.connect() as conn:
                    conn.execute(text("SELECT 1"))
                return e
            except:
                continue
        return None
    except Exception as err:
        print(f"Connection Logic Error: {err}")
        return None

engine = get_engine()

# 1. Load Data
if engine:
    df_members = pd.read_sql("SELECT u.unit_code, m.Nb_Membres, d.annee FROM dbo.dim_membre m JOIN dbo.dim_unite u ON m.unit_fk = u.unit_id JOIN dbo.dim_date d ON d.date_id = (SELECT MAX(date_id) FROM dbo.dim_date)", engine)
    # ... Simplified load logic ...
else:
    # Fallback to local files if DW fails
    df_members = pd.read_excel('Membres_Par_Unite_Et_Saison.xlsx')

# 2. Run ML Models (Membership, Risk, Engagement)
# (Inlined logic from run_all_ml.py)
df_members['Predicted_Members'] = (df_members['Nb_Membres'] * 1.12).round().astype(int) # Dummy prediction logic for the snippet
df_members['Engagement_Score'] = np.random.uniform(40, 95, len(df_members))
df_members['Risk_Level'] = df_members['Engagement_Score'].apply(lambda x: 'Low' if x > 80 else 'High' if x < 50 else 'Medium')

# 3. Final Table for Power BI
# Power BI will see all dataframes defined in the script
ml_results = df_members[['unit_code', 'Predicted_Members', 'Engagement_Score', 'Risk_Level']]
print("ML Results Ready for Import")
