import pandas as pd
import numpy as np

    
    def classify_perf(taux):
        if taux > 0.75: return "High"
        if taux < 0.40: return "Low"
        return "Medium"
        
    df['Performance_Tier'] = df['Taux_Participation'].apply(classify_perf)
    df['Alerte_Risque'] = df['Performance_Tier'].apply(lambda x: "🔴 Risque élevé" if x == "Low" else "✅ Ok")

# 4. Résultat final pour Power BI
final_dw_results = df
