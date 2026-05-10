import pandas as pd
import numpy as np
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
from sklearn.ensemble import IsolationForest
import warnings
warnings.filterwarnings('ignore')

# ── PREP ────────────────────────────────────────────────────────────────────
df = dataset.copy()
df.columns = [c.strip() for c in df.columns]

rename_map = {
    'unit_code': 'Code_Unite',
    'promised_amount_TND': 'Budget_Alloue',
    'Received_amount_TND': 'Budget_Consomme',
}
for old, new in rename_map.items():
    if old in df.columns: df.rename(columns={old: new}, inplace=True)

for col in ['Budget_Alloue', 'Budget_Consomme']:
    if col in df.columns:
        df[col] = pd.to_numeric(df[col], errors='coerce').fillna(0)

df = df.dropna(subset=['Code_Unite'])
df = df.groupby('Code_Unite').agg({'Budget_Alloue': 'sum', 'Budget_Consomme': 'sum'}).reset_index()
df = df[df['Budget_Alloue'] > 0].reset_index(drop=True)

df['Ratio'] = (df['Budget_Consomme'] / df['Budget_Alloue']).clip(0, 2)

# ── ML: Anomaly Detection ────────────────────────────────────────────────────
df['Anomaly'] = 1
if len(df) >= 5:
    iso = IsolationForest(contamination=0.15, random_state=42)
    df['Anomaly'] = iso.fit_predict(df[['Budget_Alloue', 'Budget_Consomme']].values)

# ── COLORS ───────────────────────────────────────────────────────────────────
def bar_color(row):
    if row['Anomaly'] == -1:  return '#e74c3c'   # anomaly = red
    if row['Ratio'] > 1.05:   return '#ff6b35'   # over budget = orange
    if row['Ratio'] >= 0.85:  return '#2ecc71'   # healthy = green
    return '#f1c40f'                              # under-used = yellow

df['Color'] = df.apply(bar_color, axis=1)
df = df.sort_values('Ratio', ascending=True).reset_index(drop=True)

# ── PLOT ─────────────────────────────────────────────────────────────────────
fig, ax = plt.subplots(figsize=(10, max(6, len(df) * 0.55)))
fig.patch.set_facecolor('#0d1117')
ax.set_facecolor('#161b22')

bars = ax.barh(df['Code_Unite'], df['Ratio'], color=df['Color'], alpha=0.88,
               edgecolor='#ffffff11', height=0.6, zorder=3)

# Value labels
for bar, (_, row) in zip(bars, df.iterrows()):
    w = bar.get_width()
    label = f"{w:.2f}"
    if row['Anomaly'] == -1: label += '  ⚠'
    ax.text(w + 0.01, bar.get_y() + bar.get_height()/2,
            label, va='center', ha='left', fontsize=9,
            color='#e74c3c' if row['Anomaly'] == -1 else 'white', fontweight='bold')

ax.axvline(x=1.0, color='white', linestyle='--', linewidth=1.5, alpha=0.6, label='Target = 1.0')
ax.axvline(x=0.85, color='#f1c40f', linestyle=':', linewidth=1, alpha=0.5, label='Min threshold')
ax.axvline(x=1.05, color='#ff6b35', linestyle=':', linewidth=1, alpha=0.5, label='Over-budget limit')

ax.set_xlabel('Consumed / Allocated Ratio', color='white', fontsize=11)
ax.set_title('💰  Budget Efficiency  —  Isolation Forest Anomaly Detection\n(⚠ = Flagged anomaly)',
             fontsize=13, fontweight='bold', color='white', pad=15)
ax.tick_params(colors='white')
ax.xaxis.set_tick_params(labelcolor='white')
ax.yaxis.set_tick_params(labelcolor='white')
for spine in ax.spines.values(): spine.set_edgecolor('#30363d')
ax.grid(axis='x', color='#30363d', linestyle='--', alpha=0.4, zorder=0)

n_anomalies = int((df['Anomaly'] == -1).sum())
ax.annotate(f'Anomalies detected: {n_anomalies}', xy=(0.01, 0.02),
            xycoords='axes fraction', fontsize=9, color='#e74c3c', fontweight='bold')

ax.legend(facecolor='#21262d', labelcolor='white', fontsize=9, loc='lower right')
plt.tight_layout()
plt.show()
