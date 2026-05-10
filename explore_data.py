import pandas as pd
import json

datasets = [
    ('Membres_Par_Unite_Et_Saison.xlsx', 'c:/Users/MSI/Desktop/wetransfer_scouts_2026-02-28_1339/Scouts/Membres_Par_Unite_Et_Saison.xlsx'),
    ('Activites_Generales.xlsx', 'c:/Users/MSI/Desktop/wetransfer_scouts_2026-02-28_1339/Scouts/Activites_Generales.xlsx'),
    ('Budgets_et_finances.xlsx', 'c:/Users/MSI/Desktop/wetransfer_scouts_2026-02-28_1339/Scouts/Budgets_et_finances.xlsx'),
    ('events_weather_kpis_tunisia.xlsx', 'c:/Users/MSI/Desktop/wetransfer_scouts_2026-02-28_1339/Scouts/events_weather_kpis_tunisia.xlsx')
]

summary = {}
for name, path in datasets:
    try:
        df = pd.read_excel(path)
        summary[name] = {
            'columns': list(df.columns),
            'shape': df.shape
        }
    except Exception as e:
        summary[name] = str(e)

print(json.dumps(summary, indent=4))
