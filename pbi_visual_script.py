# ==============================================================================
# ML CHAMP VISUALISATION - BAREBONES MATPLOTLIB VERSION
# ==============================================================================
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

try:
    # 1. Access Data
    df = dataset # No copy, use directly

    # 2. Extract Columns (Case Insensitive)
    def find_col(k):
        for c in df.columns:
            if k.lower() in c.lower(): return c
        return None

    u_col = find_col('unit_code') or find_col('unite') or 'unit_code'
    m_col = find_col('Nb_Membres') or find_col('membres') or 'Nb_Membres'
    p_col = find_col('Nb_Participants') or find_col('participants') or 'Nb_Participants'
    a_col = find_col('Nb_Activites') or find_col('activites') or 'Nb_Activites'

    # 3. Simple Math (No ML libraries)
    x = pd.to_numeric(df[p_col], errors='coerce').fillna(0)
    y = pd.to_numeric(df[m_col], errors='coerce').fillna(0)
    names = df[u_col].astype(str)

    # 4. Minimal Plot
    plt.figure(figsize=(8, 6))
    plt.scatter(x, y, color='blue', alpha=0.5, s=100)
    
    for i, txt in enumerate(names):
        plt.annotate(txt, (x.iloc[i], y.iloc[i]))

    plt.title("Minimal Diagnostic Plot")
    plt.xlabel("Participants")
    plt.ylabel("Members")
    plt.grid(True)
    plt.show()

except Exception as e:
    plt.figure()
    plt.text(0.5, 0.5, f"ERROR: {str(e)}", color='red')
    plt.show()
