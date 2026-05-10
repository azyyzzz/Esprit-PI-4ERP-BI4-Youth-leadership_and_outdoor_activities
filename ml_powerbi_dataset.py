import pandas as pd
import numpy as np

# NOTE: Dans Power BI (Power Query), vos données arrivent dans une variable nommée 'dataset'
# Ce script suppose que vous avez fusionné dim_membre, dim_unite et Fact_activite au préalable.

df = dataset.copy()

# 1. Nettoyage et Conversion (Gestion des virgules pour les nombres)
def clean_num(val):
    if isinstance(val, str):
        return float(val.replace(',', '.'))
    return val

for col in ['temp_max_mean', 'Total_Rainfall', 'Max_win_speed', 'promised_amount_TND', 'Received_amount_TND']:
    if col in df.columns:
        df[col] = df[col].apply(clean_num)

# 2. ML Objective 1 & 2: Membership & Participation
# Calcul du taux de participation (basé sur l'échantillon fourni)
if 'Nb_Participants' in df.columns and 'nb_activites' in df.columns:
    df['Participation_Rate'] = (df['Nb_Participants'] / (df['nb_activites'] + 1)).clip(0, 1)
else:
    df['Participation_Rate'] = 0.65 # Valeur par défaut si colonnes manquantes

# 3. ML Objective 5 & 6: Performance & Risk
def get_tier(row):
    if row['Participation_Rate'] > 0.7: return 'High'
    if row['Participation_Rate'] < 0.3: return 'Low'
    return 'Medium'

df['Performance_Tier'] = df.apply(get_tier, axis=1)
df['Is_At_Risk'] = (df['Performance_Tier'] == 'Low').astype(int)

# 4. ML Objective 8: Engagement Score (0-100)
df['Engagement_Score'] = (df['Participation_Rate'] * 100).round(1)

# 5. ML Objective 11: Early Warning System
df['Alert_Message'] = df.apply(lambda r: "🔴 Alerte : Désengagement" if r['Is_At_Risk'] else "✅ Normal", axis=1)

# Le résultat final doit être stocké dans une variable que Power BI pourra lire
final_ml_results = df
