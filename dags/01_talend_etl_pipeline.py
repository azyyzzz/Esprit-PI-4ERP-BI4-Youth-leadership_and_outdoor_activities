"""
DAG Airflow pour exécuter les jobs Talend ETL
Pipeline: SA -> DIM -> FACT
"""
import os
from airflow import DAG
from airflow.operators.bash import BashOperator
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

def normalize_schedule(schedule_value):
    value = (schedule_value or '').strip()
    return None if value.lower() in {'none', 'manual', 'off', ''} else value


def create_talend_pipeline(dag_id, schedule_value, description):
    with DAG(
        dag_id=dag_id,
        default_args=default_args,
        description=description,
        schedule=normalize_schedule(schedule_value),
        start_date=datetime(2024, 1, 1),
        catchup=False,
        tags=['talend', 'etl', 'pipeline'],
    ) as dag:
        run_sa_job = BashOperator(
            task_id='run_staging_area',
            bash_command='bash -c "cd /opt/airflow/talend/SA_master/Scout_SA_RUN_0.1/Scout_SA_RUN && ./Scout_SA_RUN_run.sh"',
        )

        run_dim_job = BashOperator(
            task_id='run_dim_dimensions',
            bash_command='bash -c "cd /opt/airflow/talend/DIM_master/Scout_DW_RUN_methode2_0.1/Scout_DW_RUN_methode2 && ./Scout_DW_RUN_methode2_run.sh"',
        )

        run_fact_job = BashOperator(
            task_id='run_fact_tables',
            bash_command='bash -c "cd /opt/airflow/talend/FACT_master/master_Fact_0.1/master_Fact && ./master_Fact_run.sh"',
        )

        run_sa_job >> run_dim_job >> run_fact_job

    return dag

dag = create_talend_pipeline(
    dag_id='01_talend_etl_pipeline',
    schedule_value=os.getenv('TALEND_PIPELINE_SCHEDULE_MIDNIGHT', '0 0 * * *'),
    description='Pipeline ETL Talend: Staging Area -> Dimensions -> Facts (minuit)',
)

dag_2150 = create_talend_pipeline(
    dag_id='01_talend_etl_pipeline_2150',
    schedule_value=os.getenv('TALEND_PIPELINE_SCHEDULE_2150', '50 21 * * *'),
    description='Pipeline ETL Talend: Staging Area -> Dimensions -> Facts (21:50)',
)
