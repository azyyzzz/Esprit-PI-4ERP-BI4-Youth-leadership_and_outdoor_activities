"""
DAG Airflow détaillé pour exécuter les jobs Talend individuellement
Pipeline: SA (toutes les analytics) -> DIM (toutes les dimensions) -> FACT (toutes les facts)
"""
from airflow import DAG
from airflow.operators.bash import BashOperator
from airflow.operators.empty import EmptyOperator
from datetime import datetime, timedelta

# Configuration par défaut
default_args = {
    'owner': 'airflow',
    'depends_on_past': False,
    'email_on_failure': False,
    'email_on_retry': False,
    'retries': 1,
    'retry_delay': timedelta(minutes=5),
}

with DAG(
    dag_id='02_talend_etl_detailed',
    default_args=default_args,
    description='Pipeline ETL Talend détaillé avec tous les jobs individuels',
    schedule=None,  # Exécution manuelle
    start_date=datetime(2024, 1, 1),
    catchup=False,
    tags=['talend', 'etl', 'detailed'],
) as dag:
    
    # ========== DÉBUT ==========
    start = EmptyOperator(
        task_id='start',
        dag=dag,
    )
    
    # ========== ÉTAPE 1: STAGING AREA / ANALYTICS (SA) ==========
    sa_start = EmptyOperator(
        task_id='sa_start',
        dag=dag,
    )
    
    # Job principal SA qui exécute toutes les analyses
    sa_job = BashOperator(
        task_id='sa_all_analytics',
        bash_command='cd /opt/airflow/talend/SA_master/Scout_SA_RUN_0.1/Scout_SA_RUN && chmod +x Scout_SA_RUN_run.sh && ./Scout_SA_RUN_run.sh',
        dag=dag,
    )
    
    sa_end = EmptyOperator(
        task_id='sa_end',
        dag=dag,
    )
    
    # ========== ÉTAPE 2: DIMENSIONS (DIM) ==========
    dim_start = EmptyOperator(
        task_id='dim_start',
        dag=dag,
    )
    
    # Job principal DIM qui exécute toutes les dimensions
    dim_job = BashOperator(
        task_id='dim_all_dimensions',
        bash_command='cd /opt/airflow/talend/DIM_master/Scout_DW_RUN_methode2_0.1/Scout_DW_RUN_methode2 && chmod +x Scout_DW_RUN_methode2_run.sh && ./Scout_DW_RUN_methode2_run.sh',
        dag=dag,
    )
    
    dim_end = EmptyOperator(
        task_id='dim_end',
        dag=dag,
    )
    
    # ========== ÉTAPE 3: FACTS ==========
    fact_start = EmptyOperator(
        task_id='fact_start',
        dag=dag,
    )
    
    # Job principal FACT qui exécute toutes les tables de faits
    fact_job = BashOperator(
        task_id='fact_all_tables',
        bash_command='cd /opt/airflow/talend/FACT_master/master_Fact_0.1/master_Fact && chmod +x master_Fact_run.sh && ./master_Fact_run.sh',
        dag=dag,
    )
    
    fact_end = EmptyOperator(
        task_id='fact_end',
        dag=dag,
    )
    
    # ========== FIN ==========
    end = EmptyOperator(
        task_id='end',
        dag=dag,
    )
    
    # Définir l'ordre d'exécution: SA -> DIM -> FACT
    start >> sa_start >> sa_job >> sa_end
    sa_end >> dim_start >> dim_job >> dim_end
    dim_end >> fact_start >> fact_job >> fact_end
    fact_end >> end
