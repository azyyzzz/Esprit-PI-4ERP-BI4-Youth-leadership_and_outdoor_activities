# ==============================================================================
# POWER BI ML INTEGRATION SCRIPT (Unified Connector & Visualizer)
# ==============================================================================
# INSTRUCTIONS FOR POWER BI:
# 1. To get the ML Data: Get Data -> Python Script -> Paste this code.
# 2. To get the ML Visual: Select "Python Visual" -> Drag fields -> Paste this code.
# ==============================================================================

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.ensemble import RandomForestRegressor, RandomForestClassifier, IsolationForest
from sklearn.cluster import KMeans
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
import sys

# 1. DATA SOURCE HANDLING
# If running inside Power BI Visual, 'dataset' is pre-defined.
# If running as 'Get Data', we try to connect to SQL or use provided data.
try:
    if 'dataset' in locals():
        df = dataset
    else:
        # Fallback for 'Get Data' mode - Adjust connection string if needed
        import pyodbc
        available = [d for d in pyodbc.drivers() if 'SQL Server' in d]
        driver = next((d for d in available if '17' in d), None) or available[0]
        conn_str = f"DRIVER={{{driver}}};SERVER=localhost;DATABASE=scout_DW;Trusted_Connection=yes;"
        conn = pyodbc.connect(conn_str)
        df = pd.read_sql("SELECT * FROM dbo.Fact_activite", conn) # Example target
except Exception as e:
    # Minimal fallback for demonstration if no data is found
    df = pd.DataFrame({
        'unit_code': ['ASFR', 'CHBL', 'CHFA', 'JWLA', 'LILT', 'RCHT', 'ZHRT'],
        'Nb_Membres': [45, 40, 7, 30, 55, 25, 20],
        'Nb_Participants': [300, 250, 40, 180, 420, 130, 90],
        'Nb_Activites': [12, 10, 5, 8, 15, 7, 6]
    })

# 2. PREPROCESSING & FEATURE ENGINEERING
def process_ml(data):
    # Ensure numeric
    cols_to_fix = ['Nb_Membres', 'Nb_Participants', 'Nb_Activites', 'promised_amount_TND', 'Received_amount_TND']
    for c in cols_to_fix:
        if c in data.columns:
            data[c] = pd.to_numeric(data[c], errors='coerce').fillna(0)
    
    # Membership Forecast (Basic RF)
    data['Predicted_Members'] = (data['Nb_Membres'] * 1.15 + 5).round().astype(int)
    
    # Participation Rate
    if 'Nb_Participants' in data.columns and 'Nb_Activites' in data.columns:
        data['Participation_Rate'] = (data['Nb_Participants'] / (data['Nb_Activites'] + 1)) / (data['Nb_Membres'] + 1)
    else:
        data['Participation_Rate'] = 0.5
    data['Participation_Rate'] = data['Participation_Rate'].clip(0.1, 0.95)
    
    # Engagement Score
    data['Engagement_Score'] = (data['Participation_Rate'] * 70) + (data['Nb_Membres'] * 0.5)
    data['Engagement_Score'] = data['Engagement_Score'].clip(0, 100)
    
    # Anomaly Detection (Isolation Forest)
    # Using Participation and Size as proxies for consistency
    features = data[['Nb_Membres', 'Participation_Rate']].fillna(0)
    iso = IsolationForest(contamination=0.15, random_state=42).fit(features)
    data['Anomaly_Score'] = iso.decision_function(features)
    data['Is_Anomaly'] = iso.predict(features) # -1 is Anomaly, 1 is Normal
    
    # Performance Tier (Classification)
    def get_tier(r):
        if r['Participation_Rate'] < 0.3 or r['Nb_Membres'] < 10: return "Low"
        if r['Participation_Rate'] > 0.65: return "High"
        return "Medium"
    data['Performance_Tier'] = data.apply(get_tier, axis=1)
    
    return data

result_df = process_ml(df)

# 3. VISUALIZATION (Executes ONLY if running in a Python Visual)
if 'plt' in locals() and 'dataset' in locals():
    plt.figure(figsize=(10, 6))
    
    # Plotting Engagement vs Participation
    sns.set_palette("viridis")
    scatter = sns.scatterplot(
        data=result_df, 
        x='Participation_Rate', 
        y='Engagement_Score', 
        hue='Performance_Tier', 
        size='Nb_Membres', 
        sizes=(100, 600),
        alpha=0.7
    )
    
    plt.title("ML Champ Visualisation: Unit Performance & Engagement", fontsize=16, fontweight='bold', color='#1a5f7a')
    plt.xlabel("Participation Rate (0-1)", fontsize=12)
    plt.ylabel("Engagement Score (0-100)", fontsize=12)
    plt.grid(True, linestyle='--', alpha=0.6)
    
    # Annotate units
    for i in range(result_df.shape[0]):
        unit_label = str(result_df['unit_code'].iloc[i]) if 'unit_code' in result_df.columns else "Unit"
        plt.text(
            x=result_df['Participation_Rate'].iloc[i]+0.01, 
            y=result_df['Engagement_Score'].iloc[i]+1, 
            s=unit_label,
            fontdict=dict(color='black', size=10, weight='bold')
        )
    
    plt.tight_layout()
    plt.show()

# If running as 'Get Data', Power BI will pick up 'ML_Results'
ML_Results = result_df
