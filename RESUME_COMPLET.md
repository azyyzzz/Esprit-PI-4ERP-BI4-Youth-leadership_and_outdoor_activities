# 📋 Résumé Complet du Projet Airflow + Talend

## 🎯 Objectif
Orchestrer vos jobs ETL Talend avec Apache Airflow dans Docker pour automatiser le pipeline de données :
- **SA** (Staging Area) → **DIM** (Dimensions) → **FACT** (Facts)

---

## 🛠️ Ce qui a été mis en place

### 1. **Environnement Docker avec Airflow**
- **PostgreSQL** : Base de données pour les métadonnées d'Airflow
- **Airflow Webserver** : Interface web sur http://localhost:8080
- **Airflow Scheduler** : Exécute les jobs selon le planning
- **Java 17** : Installé dans les conteneurs pour exécuter les jobs Talend

**Fichiers** :
- `docker-compose.yaml` : Configuration des services
- `Dockerfile` : Image personnalisée avec Java et outils réseau

---

## ⚙️ Problèmes rencontrés et solutions

### **Problème 1 : SQL Server inaccessible depuis Docker**

**❌ Erreur** :
```
Connection refused: localhost:1433
```

**💡 Explication** :
- Les conteneurs Docker ont leur propre réseau isolé
- `localhost` dans un conteneur ≠ `localhost` sur Windows
- Les jobs Talend compilés (JAR) contiennent des connexions codées en dur vers `localhost`

**✅ Solution : Proxy TCP avec Socat**

Création d'un **tunnel réseau** qui redirige automatiquement :
```
localhost:1433 (dans le conteneur) → host.docker.internal:1433 (Windows)
```

**Fichiers modifiés** :
- `entrypoint-wrapper.sh` : Démarre le proxy au lancement des conteneurs
- `docker-compose.yaml` : Configure `extra_hosts` pour `host.docker.internal`
- `fix_talend_connections.sh` : Remplace `localhost` par `host.docker.internal` dans les fichiers `.item`

**Configuration Windows** :
- Activation TCP/IP sur SQL Server (port 1433)
- Règle de pare-feu Windows pour autoriser le port 1433

---

### **Problème 2 : Fichiers Excel inaccessibles**

**❌ Erreur** :
```
FileNotFoundException: C:/Projet_PI_BI/Youth Leadership & Outdoor Education/Scouts/Activites_Generales.xlsx
```

**💡 Explication** :
- Les jobs SA lisent des fichiers Excel depuis votre disque Windows
- Docker ne peut pas accéder directement à `C:/Projet_PI_BI`
- Java interprète `C:/` comme un chemin relatif sur Linux

**✅ Solution : Montage de volume + Liens symboliques**

**Étape 1** : Monter le dossier Windows dans Docker
```yaml
volumes:
  - C:/Projet_PI_BI:/opt/airflow/projet_pi_bi:ro
```

**Étape 2** : Créer des liens symboliques dans chaque répertoire de job
```bash
# Pour chaque job (SA, DIM, FACT), créer :
mkdir -p C:
ln -s /opt/airflow/projet_pi_bi C:/Projet_PI_BI
```

**Résultat** :
- Quand Java cherche `C:/Projet_PI_BI/fichier.xlsx`
- Il trouve en réalité `/opt/airflow/projet_pi_bi/fichier.xlsx`
- Qui est monté depuis `C:/Projet_PI_BI` sur Windows

**Fichiers modifiés** :
- `entrypoint-wrapper.sh` : Crée automatiquement les liens au démarrage
- `fix_excel_paths.ps1` : Script qui a modifié 29 fichiers `.item`

---

## 📂 Structure finale

```
airflow-docker/
├── docker-compose.yaml          # Configuration Docker
├── Dockerfile                   # Image personnalisée
├── entrypoint-wrapper.sh        # Script de démarrage (proxy + liens)
├── dags/
│   └── 01_talend_etl_pipeline.py    # Pipeline SA → DIM → FACT
├── talend/                      # Jobs Talend montés dans Docker
│   ├── SA_master/
│   ├── DIM_master/
│   └── FACT_master/
├── logs/                        # Logs d'exécution
└── plugins/                     # Plugins Airflow (vide)
```

---

## 🔄 Comment ça fonctionne maintenant

### Au démarrage du conteneur :

1. **Socat** démarre et crée le tunnel SQL Server
2. Les **liens symboliques** sont créés pour les fichiers Excel
3. **Airflow** démarre et lit le DAG

### Quand vous lancez le DAG :

1. **Job SA** s'exécute :
   - Lit les fichiers Excel via `C:/Projet_PI_BI` (lien symbolique)
   - Se connecte à SQL Server via `localhost:1433` (proxy socat)
   - Charge les données dans la Staging Area

2. **Job DIM** s'exécute ensuite :
   - Se connecte à SQL Server via le proxy
   - Crée/met à jour les tables de dimensions

3. **Job FACT** s'exécute en dernier :
   - Se connecte à SQL Server via le proxy
   - Crée/met à jour les tables de faits

---

## 🚀 Comment utiliser

### Démarrer l'environnement :
```powershell
docker-compose up -d
```

### Accéder à l'interface Airflow :
- URL : http://localhost:8080
- Login : `admin`
- Mot de passe : `admin`

### Lancer le pipeline :
1. Aller dans l'interface web
2. Trouver le DAG `talend_etl_pipeline`
3. Cliquer sur le bouton ▶️ (Play)

### Arrêter l'environnement :
```powershell
docker-compose down
```

### Voir les logs :
```powershell
docker-compose logs -f
```

---

## 🔧 Scripts utiles créés

| Script | Description |
|--------|-------------|
| `fix_talend_connections.sh` | Remplace `localhost` par `host.docker.internal` dans les connexions SQL |
| `fix_excel_paths.ps1` | Remplace `C:/Projet_PI_BI` par `/opt/airflow/projet_pi_bi` dans les fichiers Excel |
| `entrypoint-wrapper.sh` | Démarre le proxy SQL et crée les liens symboliques automatiquement |

---

## 📊 Architecture réseau

```
┌─────────────────────────────────────────────────────────┐
│                    WINDOWS HOST                         │
│                                                         │
│  SQL Server (MSSQLSERVERAZIZ)                          │
│  Port 1433 ←──────────────────────┐                    │
│                                    │                    │
│  C:/Projet_PI_BI/ (fichiers)      │                    │
│         │                          │                    │
└─────────┼──────────────────────────┼─────────────────────┘
          │                          │
          │ (volume mount)           │ (réseau)
          ↓                          │
┌─────────────────────────────────────────────────────────┐
│           DOCKER CONTAINER (Airflow)                    │
│                                                         │
│  /opt/airflow/projet_pi_bi/ ←─────┘ (monté)           │
│         ↑                                              │
│         │ (lien symbolique)                            │
│         │                                              │
│  C:/Projet_PI_BI/ (dans le répertoire du job)         │
│                                                         │
│  Socat Proxy:                                          │
│  localhost:1433 → host.docker.internal:1433            │
│         │                          ↑                    │
│         └──────────────────────────┘                    │
│                                                         │
│  Jobs Talend (Java) ───→ cherchent localhost:1433      │
│                    ───→ cherchent C:/Projet_PI_BI      │
└─────────────────────────────────────────────────────────┘
```

---

## ✅ Vérifications de bon fonctionnement

### Tester la connexion SQL Server :
```powershell
docker exec airflow-docker-airflow-scheduler-1 bash -c "timeout 5 bash -c '</dev/tcp/localhost/1433' && echo 'SQL OK'"
```

### Tester l'accès aux fichiers Excel :
```powershell
docker exec airflow-docker-airflow-scheduler-1 ls -la "/opt/airflow/projet_pi_bi/Youth Leadership & Outdoor Education/Scouts/"
```

### Tester un job manuellement :
```powershell
# SA
docker exec airflow-docker-airflow-scheduler-1 bash -c "cd /opt/airflow/talend/SA_master/Scout_SA_RUN_0.1/Scout_SA_RUN && ./Scout_SA_RUN_run.sh"

# DIM
docker exec airflow-docker-airflow-scheduler-1 bash -c "cd /opt/airflow/talend/DIM_master/Scout_DW_RUN_methode2_0.1/Scout_DW_RUN_methode2 && ./Scout_DW_RUN_methode2_run.sh"

# FACT
docker exec airflow-docker-airflow-scheduler-1 bash -c "cd /opt/airflow/talend/FACT_master/master_Fact_0.1/master_Fact && ./master_Fact_run.sh"
```

---

## 🎓 Concepts clés à retenir

### 1. **Docker Network Isolation**
Les conteneurs ont leur propre réseau. `localhost` dans un conteneur ne pointe PAS vers votre machine Windows.

### 2. **Volume Mounting**
Permet de partager des fichiers entre Windows et Docker. Les fichiers restent sur Windows mais sont visibles dans le conteneur.

### 3. **Symbolic Links (Liens symboliques)**
Créent des "raccourcis" dans le système de fichiers Linux. Quand Java cherche `C:/Projet_PI_BI`, il trouve le lien qui pointe vers `/opt/airflow/projet_pi_bi`.

### 4. **TCP Proxy with Socat**
Redirige le trafic réseau d'un port vers un autre. Notre proxy intercepte toutes les connexions à `localhost:1433` et les envoie vers SQL Server sur Windows.

### 5. **Airflow DAG**
Fichier Python qui définit le workflow : quels jobs exécuter, dans quel ordre, avec quelles dépendances.

---

## 🔐 Informations de connexion

| Service | URL/Host | Utilisateur | Mot de passe |
|---------|----------|-------------|--------------|
| Airflow Web | http://localhost:8080 | admin | admin |
| PostgreSQL | localhost:5432 | airflow | airflow |
| SQL Server | localhost:1433 | (votre utilisateur SQL) | (votre mot de passe) |

---

## 📝 Fichiers de configuration importants

### `docker-compose.yaml`
```yaml
# Points clés :
- Montage du volume C:/Projet_PI_BI
- Configuration extra_hosts pour host.docker.internal
- User root pour permettre à socat d'utiliser le port 1433
- Entrypoint personnalisé : /entrypoint-wrapper.sh
```

### `entrypoint-wrapper.sh`
```bash
# Actions au démarrage :
1. Démarre le proxy socat
2. Crée les répertoires C: dans chaque job
3. Crée les liens symboliques vers projet_pi_bi
4. Lance Airflow
```

### `dags/01_talend_etl_pipeline.py`
```python
# Pipeline défini :
SA → DIM → FACT
# Chaque job est un BashOperator qui exécute le script .sh
```

---

## 🎉 Résultat final

Vous avez maintenant un environnement Airflow complètement fonctionnel qui :

✅ Exécute vos jobs Talend dans le bon ordre  
✅ Se connecte à votre SQL Server Windows  
✅ Lit les fichiers Excel depuis votre disque  
✅ Offre une interface web pour surveiller et lancer les pipelines  
✅ Redémarre automatiquement en cas de problème  
✅ Persiste les données (PostgreSQL en volume Docker)  

---

## 📞 Commandes de dépannage

### Voir les logs d'un conteneur :
```powershell
docker logs airflow-docker-airflow-scheduler-1 -f
```

### Entrer dans un conteneur :
```powershell
docker exec -it airflow-docker-airflow-scheduler-1 bash
```

### Redémarrer proprement :
```powershell
docker-compose down
docker-compose up -d
```

### Reconstruire l'image après modification :
```powershell
docker-compose build
docker-compose up -d
```

---

**Créé le : Mars 2026**  
**Environnement : Windows + Docker Desktop + Apache Airflow 2.9.3**
Bonjour, dans ce projet j’ai automatisé un pipeline ETL Talend avec Apache Airflow dans Docker.
Mon objectif était d’orchestrer les traitements dans un ordre métier strict : SA puis DIM puis FACT.
J’ai d’abord mis en place l’environnement technique : Airflow Webserver, Scheduler, PostgreSQL, Java pour Talend, et la collecte des logs.
Ensuite, j’ai configuré l’exécution automatique avec le scheduler à deux horaires par jour : 00h00 et 21h50.
Comme Airflow 2.9 ne permet pas facilement deux cron différents dans un seul DAG, j’ai créé deux DAGs équivalents : un DAG pour minuit et un DAG pour 21h50, avec la même chaîne de tâches SA → DIM → FACT.
J’ai validé que ce n’est pas manuel grâce aux preuves Airflow :

schedule_interval affiche bien 0 0 * * * et 50 21 * * *,
les DAGs sont is_active=True et is_paused=False.
Donc le système est bien automatisé, supervisé, et reproductible.”
Si tu veux, je te fais aussi une version “très simple” en français facile (30 secondes).

GPT-5.3-Codex • 0.9x