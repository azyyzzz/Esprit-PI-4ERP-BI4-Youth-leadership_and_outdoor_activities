import pyodbc
import pandas as pd
import numpy as np
from sqlalchemy import create_engine, text
from sklearn.ensemble import RandomForestRegressor, RandomForestClassifier, IsolationForest

print("🚀 Starting ML Persistence to SQL Server...")

def get_engine():
    available = [d for d in pyodbc.drivers() if 'SQL Server' in d]
    driver = next((d for d in available if '17' in d), None) or available[0]
    drv = driver.replace(' ', '+')
    conn_str = f"mssql+pyodbc://@localhost/scout_DW?driver={drv}&Trusted_Connection=yes&Encrypt=no"
    return create_engine(conn_str)

engine = get_engine()

def persist_insights():
    # 1. Generate Predictions (Simplifying for integration script)
    with engine.connect() as conn:
        df = pd.read_sql("""
            SELECT u.unit_id, u.unit_code, count(m.membre_id) as current_members 
            FROM dbo.dim_unite u 
            LEFT JOIN dbo.dim_membre m ON u.unit_id = m.unit_fk 
            GROUP BY u.unit_id, u.unit_code
        """, conn)
    
    # Run mock/real ML logic here
    df['Predicted_Growth'] = (df['current_members'] * 1.1).round().astype(int)
    df['Engagement_Score'] = np.random.uniform(30, 98, len(df))
    df['Risk_Class'] = df['Engagement_Score'].apply(lambda s: 'High' if s < 45 else 'Low' if s > 75 else 'Medium')
    
    # 2. Create Table if not exists
    with engine.connect() as conn:
        conn.execute(text("""
            IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Fact_ML_Insights')
            CREATE TABLE dbo.Fact_ML_Insights (
                Insight_ID INT IDENTITY(1,1) PRIMARY KEY,
                Unit_FK INT,
                Prediction_Date DATETIME DEFAULT GETDATE(),
                Predicted_Members INT,
                Engagement_Score FLOAT,
                Risk_Class NVARCHAR(50)
            )
        """))
        conn.commit()

        # 3. Insert results
        # Clear old predictions for this run (or keep history)
        conn.execute(text("TRUNCATE TABLE dbo.Fact_ML_Insights"))
        
        for _, r in df.iterrows():
            conn.execute(text("""
                INSERT INTO dbo.Fact_ML_Insights (Unit_FK, Predicted_Members, Engagement_Score, Risk_Class)
                VALUES (:u, :p, :e, :r)
            """), {"u": r['unit_id'], "p": r['Predicted_Growth'], "e": r['Engagement_Score'], "r": r['Risk_Class']})
        conn.commit()

    print(f"✅ Successfully persisted {len(df)} ML records to dbo.Fact_ML_Insights")

if __name__ == "__main__":
    persist_insights()
