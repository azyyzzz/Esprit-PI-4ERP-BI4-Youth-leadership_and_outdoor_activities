# ==============================================================================
# ML CHAMP VISUAL - UNIT INTELLIGENCE (BUBBLE CHART)
# ==============================================================================
# INSTRUCTIONS:
# 1. Drag these fields: unit_code, NbMembres, NbParticipants, nb_activites
# 2. CRITICAL: For ALL fields, select "DO NOT SUMMARIZE" in the Values well!
# ==============================================================================

import pandas as pd
import numpy as np
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
from sklearn.ensemble import RandomForestRegressor
from sklearn.preprocessing import LabelEncoder
import warnings
import sys
warnings.filterwarnings('ignore')

def draw_msg(msg, color='blue'):
    fig, ax = plt.subplots(figsize=(10, 5))
    fig.patch.set_facecolor('#0d1117')
    ax.set_facecolor('#161b22')
    ax.text(0.5, 0.5, msg, ha='center', va='center', color=color, 
            fontsize=12, transform=ax.transAxes, wrap=True)
    plt.show()

try:
    if 'dataset' not in locals():
        draw_msg("No data found. Drag fields into the Values well.", 'red')
        sys.exit()

    df = dataset.copy()
    
    # --- 1. FUZZY COLUMN MAPPING ---
    def get_col(candidates):
        cols = [c.lower() for c in df.columns]
        for cand in candidates:
            c_low = cand.lower()
            if c_low in cols: return df.columns[cols.index(c_low)]
            for real in df.columns:
                if real.lower().endswith(f"[{c_low}]"): return real
        return None

    unit_col = get_col(['unit_code', 'unitcode', 'unite'])
    mem_col  = get_col(['nbmembres', 'membres', 'members', 'Nb_Membres'])
    pts_col  = get_col(['nbparticipants', 'participants', 'Nb_Participants'])
    act_col  = get_col(['nb_activites', 'activites', 'activities', 'nbactivites'])

    if not (unit_col and mem_col and pts_col and act_col):
        draw_msg(f"Missing Fields!\nNeed: unit_code, NbMembres, NbParticipants, nb_activites\nFound: {list(df.columns)}", 'red')
        sys.exit()

    # --- 2. DATA CLEANING & AGGREGATION ---
    # We aggregate just in case Power BI didn't do it right
    df[mem_col] = pd.to_numeric(df[mem_col], errors='coerce').fillna(0)
    df[pts_col] = pd.to_numeric(df[pts_col], errors='coerce').fillna(0)
    df[act_col] = pd.to_numeric(df[act_col], errors='coerce').fillna(0)
    
    df = df.groupby(unit_col, as_index=False).agg({
        mem_col: 'sum',
        pts_col: 'sum',
        act_col: 'sum'
    })
    
    if len(df) <= 1:
        # Diagnostic: Show what we actually have
        msg = f"Only {len(df)} unit(s) found: {list(df[unit_col].unique()) if unit_col in df.columns else 'N/A'}\n"
        msg += f"Raw dataset rows: {len(dataset)}\n"
        msg += f"Columns: {list(dataset.columns)}\n"
        msg += f"First 2 rows:\n{dataset.head(2).to_string()}\n"
        msg += "TIP: If you see only 1 unit but have many, go to the 'MODEL' view and ensure your tables are linked by unit_id."
        draw_msg(msg, 'orange')
    
    if len(df) == 0:
        draw_msg("No data with members > 0 found.")
        sys.exit()

    # --- 3. CALCULATIONS ---
    df['Participation'] = (df[pts_col] / df[mem_col].replace(0, np.nan)).fillna(0).clip(0, 1) * 100
    df['Engagement']    = ((df['Participation'] / 100) * 60 + (df[mem_col] / df[act_col].replace(0, 1)) * 2).clip(0, 100)

    def rate(row):
        m, p = row[mem_col], row['Participation']
        if m > 40 and p > 70: return 'Elite'
        if m > 15 and p > 40: return 'Standard'
        return 'Emerging'
    df['Rating'] = df.apply(rate, axis=1)

    # --- 4. ML: PREDICTIVE ---
    df['Predicted'] = df['Engagement'] # Default if ML fails
    if len(df) >= 3:
        try:
            le = LabelEncoder()
            unit_enc = le.fit_transform(df[unit_col].astype(str))
            X = np.column_stack([unit_enc, df[mem_col], df['Participation']])
            rf = RandomForestRegressor(n_estimators=50, random_state=42)
            rf.fit(X, df['Engagement'])
            df['Predicted'] = rf.predict(X).clip(0, 100)
        except: pass

    # --- 5. PLOTTING ---
    color_map = {'Elite': '#2ecc71', 'Standard': '#f1c40f', 'Emerging': '#e74c3c'}
    
    fig, ax = plt.subplots(figsize=(13, 8))
    fig.patch.set_facecolor('#0d1117')
    ax.set_facecolor('#161b22')

    # Bubble size logic
    mn, mx = df[mem_col].min(), df[mem_col].max()
    sizes = ((df[mem_col] - mn) / (mx - mn + 1e-6) * 500 + 100)

    # Bubbles
    scatter = ax.scatter(df['Participation'], df['Engagement'], 
                         c=df['Rating'].map(color_map), s=sizes, 
                         alpha=0.85, edgecolors='white', zorder=4)

    # Predictions (X)
    ax.scatter(df['Participation'], df['Predicted'], marker='x', 
               c='white', s=50, alpha=0.6, zorder=5)

    # Connectors & Labels
    for _, r in df.iterrows():
        ax.plot([r['Participation'], r['Participation']], [r['Engagement'], r['Predicted']], 
                color='white', alpha=0.2, linewidth=1, zorder=3)
        ax.text(r['Participation']+0.5, r['Engagement']+0.5, str(r[unit_col]), 
                color='white', fontsize=9, fontweight='bold')

    plt.title(f'⚡ ML Champ Visual: Unit Intelligence Hub ({len(df)} Units Detected)', 
              color='white', fontsize=14, fontweight='bold', pad=20)
    plt.xlabel('Participation Rate (%)', color='white')
    plt.ylabel('Engagement Score (0-100)', color='white')
    ax.tick_params(colors='white')
    ax.grid(color='#30363d', linestyle='--', alpha=0.4)
    
    # Legend
    legend_elements = [mpatches.Patch(color=v, label=k) for k, v in color_map.items()]
    legend_elements.append(mpatches.Patch(edgecolor='white', facecolor='none', label='X = Predicted'))
    ax.legend(handles=legend_elements, facecolor='#21262d', labelcolor='white', loc='lower right')
    
    plt.tight_layout()
    plt.show()

except Exception as major_err:
    draw_msg(f"Critical Script Error: {str(major_err)}", 'red')
