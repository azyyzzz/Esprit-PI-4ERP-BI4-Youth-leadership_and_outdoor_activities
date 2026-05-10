import pandas as pd
import numpy as np

# Chemins des fichiers (ajustés à votre dossier)
PATH = r'c:/Users/MSI/Desktop/wetransfer_scouts_2026-02-28_1339/Scouts/'

print("Chargement des fichiers Excel...")

try:
    # 1. Chargement des données sources
    df_m = pd.read_excel(PATH + 'Membres_Par_Unite_Et_Saison.xlsx')
    df_a = pd.read_excel(PATH + 'Activites_Generales.xlsx')
    df_b = pd.read_excel(PATH + 'Budgets_et_finances.xlsx')
    df_w = pd.read_excel(PATH + 'events_weather_kpis_tunisia.xlsx')

    # 2. Préparation et Fusion (Jointure sur Code_Unite / unit_FK)
    # On agrège les activités par unité pour avoir un taux de participation
    df_a_agg = df_a.groupby('unit_FK').agg({'Nb_Participants': 'sum', 'nb_activites': 'sum'}).reset_index()

    # Fusion avec les membres
    df_final = df_m.merge(df_a_agg, left_on='unit_id', right_on='unit_FK', how='left')

    # 3. Calculs ML
    # Taux de participation
    df_final['Participation_Rate'] = (df_final['Nb_Participants'] / (df_final['Nb_Membres'] + 1)).clip(0.1, 0.95)
    
    # Score d'engagement (0-100)
    df_final['Engagement_Score'] = (df_final['Participation_Rate'] * 100).round(1)
    
    # Classification de performance
    def get_tier(r):
        if r['Engagement_Score'] > 75: return 'High'
        if r['Engagement_Score'] < 40: return 'Low'
        return 'Medium'
    df_final['Performance_Tier'] = df_final.apply(get_tier, axis=1)
    
    # Prévision de croissance (Exemple ML simplifié)
    df_final['Predicted_Members_2026'] = (df_final['Nb_Membres'] * 1.08).round().astype(int)

    # 4. Détection d'At-Risk
    df_final['Status'] = df_final['Engagement_Score'].apply(lambda x: '🔴 At-Risk' if x < 45 else '✅ Healthy')

    # Résultat final pour Power BI
    ml_results = df_final

    print("✅ Intégration ML terminée avec succès !")

except Exception as e:
    print(f"Erreur lors du traitement : {e}")
    # En cas d'erreur, on crée une table vide pour ne pas bloquer Power BI
    ml_results = pd.DataFrame({'Error': [str(e)]})
