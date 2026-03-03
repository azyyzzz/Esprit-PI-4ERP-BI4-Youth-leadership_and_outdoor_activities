# Airflow + Talend ETL Pipeline

## 📋 Description
Ce projet configure Apache Airflow pour exécuter automatiquement les jobs Talend ETL dans un environnement Docker.

## 🏗️ Architecture
- **Postgres**: Base de données pour Airflow
- **Airflow Webserver**: Interface web (port 8080)
- **Airflow Scheduler**: Ordonnanceur des tâches
- **Jobs Talend**: 
  - SA (Staging Area / Analytics)
  - DIM (Dimensions)
  - FACT (Tables de faits)

## 🚀 Démarrage

### 1. Lancer l'environnement Docker
```bash
docker-compose up -d
```

### 2. Accéder à l'interface Airflow
- URL: http://localhost:8080
- Username: **admin**
- Password: **admin**

### 3. Exécuter le pipeline Talend
1. Accédez à http://localhost:8080
2. Trouvez le DAG `01_talend_etl_pipeline`
3. Activez-le (toggle à droite)
4. Cliquez sur le bouton "Play" pour lancer manuellement

## 📊 DAGs disponibles

### `00_smoke_test`
- Test simple pour vérifier qu'Airflow fonctionne
- Affiche un message et la date

### `01_talend_etl_pipeline`
- Pipeline ETL complet
- Ordre d'exécution:
  1. **SA** - Chargement des données analytiques
  2. **DIM** - Chargement des dimensions
  3. **FACT** - Chargement des tables de faits
- Planification automatique quotidienne à **00:00**

### `01_talend_etl_pipeline_2150`
- Même pipeline ETL (SA → DIM → FACT)
- Planification automatique quotidienne à **21:50**

## ✅ État de votre checklist
- **Connections & Configuration**: OK (Postgres + Airflow + montage Talend + SQL proxy + volumes)
- **DAGs & Dependencies**: OK (`SA -> DIM -> FACT` défini dans le DAG)
- **Automated Jobs (master & sub-jobs orchestrated)**: OK (jobs Talend appelés par Airflow)
- **Monitoring & Logs**: OK (UI Airflow + dossier `logs/` + scripts `logs.ps1` / `status.ps1`)
- **Scheduler integration**: ✅ complété (2 exécutions automatiques quotidiennes: 00:00 et 21:50)
- **Talend routines / custom Java code**: OK (Java 17 installé dans l'image, exécution des scripts Talend)

## 🔧 Structure des dossiers
```
airflow-docker/
├── docker-compose.yaml    # Configuration Docker
├── Dockerfile             # Image Airflow avec Java
├── dags/                  # DAGs Airflow
│   ├── 00_smoke_test.py
│   └── 01_talend_etl_pipeline.py
├── logs/                  # Logs d'exécution
├── plugins/               # Plugins Airflow (optionnels)
└── talend/               # Jobs Talend
    ├── DIM_master/       # Jobs dimensions
    ├── FACT_master/      # Jobs facts
    └── SA_master/        # Jobs staging area
```

## 🛠️ Commandes utiles

### Démarrer les services
```bash
docker-compose up -d
```

### Arrêter les services
```bash
docker-compose down
```

### Voir les logs en temps réel
```bash
# Logs Airflow webserver
docker-compose logs -f airflow-webserver

# Logs Airflow scheduler
docker-compose logs -f airflow-scheduler

# Tous les logs
docker-compose logs -f
```

### Redémarrer après modification
```bash
docker-compose restart
```

## 📝 Personnalisation

### Modifier le DAG
Les DAGs sont dans le dossier `dags/`. Vous pouvez:
- Modifier `01_talend_etl_pipeline.py` pour ajuster les paramètres
- Créer de nouveaux DAGs pour d'autres workflows
- Changer la planification via les variables dans `docker-compose.yaml`:
  - `TALEND_PIPELINE_SCHEDULE_MIDNIGHT='0 0 * * *'` - Tous les jours à minuit
  - `TALEND_PIPELINE_SCHEDULE_2150='50 21 * * *'` - Tous les jours à 21:50
  - `manual` (ou `none`) pour désactiver l'un des 2 DAGs

### Ajouter des notifications
Modifiez `default_args` dans le DAG:
```python
default_args = {
    'email': ['votre.email@example.com'],
    'email_on_failure': True,
    'email_on_retry': True,
}
```

## 🐛 Dépannage

### Le DAG n'apparaît pas
1. Vérifiez qu'il n'y a pas d'erreurs de syntaxe dans le fichier Python
2. Attendez ~30 secondes que le scheduler détecte le nouveau DAG
3. Vérifiez les logs: `docker-compose logs airflow-scheduler`

### Erreur lors de l'exécution d'un job Talend
1. Vérifiez que les scripts `.sh` ont les bonnes permissions
2. Vérifiez que Java est bien installé (déjà dans le Dockerfile)
3. Consultez les logs dans l'interface Airflow ou dans le dossier `logs/`

### Impossible d'accéder à l'interface web
1. Vérifiez que les conteneurs sont actifs: `docker-compose ps`
2. Vérifiez que le port 8080 n'est pas utilisé par un autre processus
3. Redémarrez: `docker-compose restart airflow-webserver`

## 📈 Monitoring
- Tous les logs sont dans le dossier `logs/`
- L'interface web Airflow affiche l'historique des exécutions
- Chaque tâche a des logs détaillés accessibles via l'interface

## 🔄 Workflow ETL
```
[SA: Staging Area/Analytics] 
      ↓
[DIM: Dimensions]
      ↓
[FACT: Tables de faits]
```

## 📞 Support
Pour modifier le pipeline ou ajouter de nouveaux jobs Talend:
1. Ajoutez vos jobs dans le dossier `talend/`
2. Modifiez ou créez un nouveau DAG dans `dags/`
3. Redémarrez le scheduler pour détecter les changements
