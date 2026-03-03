# 🚀 GUIDE DE DÉMARRAGE RAPIDE

## Pour lancer Airflow et exécuter vos jobs Talend:

### Étape 1: Démarrer Airflow
```powershell
.\start.ps1
```
OU
```bash
docker-compose up -d
```

### Étape 2: Accéder à l'interface web
1. Attendez 30-60 secondes que tout démarre
2. Ouvrez votre navigateur: **http://localhost:8080**
3. Connectez-vous:
   - **Username**: admin
   - **Password**: admin

### Étape 3: Lancer le pipeline Talend
1. Dans l'interface Airflow, trouvez le DAG **`01_talend_etl_pipeline`**
2. Activez le DAG (bouton toggle sur la gauche)
3. Cliquez sur le bouton ▶️ (Play) à droite
4. Sélectionnez "Trigger DAG"

### Étape 4: Suivre l'exécution
- L'interface montre l'état de chaque tâche en temps réel
- Cliquez sur une tâche pour voir ses logs détaillés
- Le pipeline s'exécute dans l'ordre: **SA → DIM → FACT**

---

## 📊 DAGs disponibles

### `01_talend_etl_pipeline` (RECOMMANDÉ)
- Pipeline simple et efficace
- Exécute les 3 étapes principales: SA, DIM, FACT

### `02_talend_etl_detailed`
- Pipeline détaillé avec marqueurs de début/fin
- Utile pour le debugging

---

## 🛠️ Commandes utiles

### Voir les logs
```powershell
.\logs.ps1
```

### Arrêter Airflow
```powershell
.\stop.ps1
```

### Redémarrer
```powershell
.\stop.ps1
.\start.ps1
```

---

## ❓ Problèmes courants

### "Le DAG n'apparaît pas"
→ Attendez 30 secondes, le scheduler détecte les DAGs automatiquement

### "Erreur lors de l'exécution"
→ Vérifiez les logs dans l'interface Airflow (cliquez sur la tâche en erreur)

### "Docker ne démarre pas"
→ Assurez-vous que Docker Desktop est en cours d'exécution

---

## 🎯 C'est tout!
Votre pipeline ETL Talend est maintenant automatisé avec Airflow! 🎉
