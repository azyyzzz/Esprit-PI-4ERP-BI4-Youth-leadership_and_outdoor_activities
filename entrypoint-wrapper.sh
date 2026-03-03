#!/bin/bash
# Script d'entrypoint pour demarrer le proxy SQL Server et creer les liens symboliques

# Demarrer socat en arriere-plan pour rediriger localhost:1433 vers host.docker.internal:1433
socat TCP-LISTEN:1433,fork,reuseaddr,su=nobody TCP:host.docker.internal:1433 &

# Creer les liens symboliques pour que les jobs Talend trouvent les fichiers Excel
# (Les jobs Java interpreteraient C:/ comme un chemin relatif sur Linux)
mkdir -p /opt/airflow/talend/SA_master/Scout_SA_RUN_0.1/Scout_SA_RUN/C:
ln -sfn /opt/airflow/projet_pi_bi /opt/airflow/talend/SA_master/Scout_SA_RUN_0.1/Scout_SA_RUN/C:/Projet_PI_BI

mkdir -p /opt/airflow/talend/DIM_master/Scout_DW_RUN_methode2_0.1/Scout_DW_RUN_methode2/C:
ln -sfn /opt/airflow/projet_pi_bi /opt/airflow/talend/DIM_master/Scout_DW_RUN_methode2_0.1/Scout_DW_RUN_methode2/C:/Projet_PI_BI

mkdir -p /opt/airflow/talend/FACT_master/master_Fact_0.1/master_Fact/C:
ln -sfn /opt/airflow/projet_pi_bi /opt/airflow/talend/FACT_master/master_Fact_0.1/master_Fact/C:/Projet_PI_BI

# Executer la commande originale d'Airflow
exec "$@"
