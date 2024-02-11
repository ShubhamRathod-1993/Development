from datetime import datetime, timedelta
from airflow import DAG
from airflow.operators.python import PythonOperator

# Define default_args for the DAG
default_args = {
    'owner': 'airflow',
    'depends_on_past': False,
    'start_date': datetime(2024, 1, 1),
    'email_on_failure': False,
    'email_on_retry': False,
    'retries': 1,
    'retry_delay': timedelta(minutes=5),
}

# Define the DAG
dag = DAG(
    'simple_etl_pipeline',
    default_args=default_args,
    description='A simple ETL pipeline with TaskFlow API',
    schedule_interval=timedelta(days=1),  # Set your desired schedule interval
)

# Define Python functions for the ETL tasks
def extract_task(**kwargs):
    # Extract logic goes here
    print("Extracting data...")
    return "extracted_data"

def transform_task(**kwargs):
    # Transform logic goes here
    task_instance = kwargs['ti']
    extracted_data = task_instance.xcom_pull(task_ids='extract_task')
    transformed_data = [item.upper() for item in extracted_data]
    print("Transforming data...")
    return transformed_data

def load_task(**kwargs):
    # Load logic goes here
    task_instance = kwargs['ti']
    transformed_data = task_instance.xcom_pull(task_ids='transform_task')
    print("Loading data...")
    print("Transformed Data:", transformed_data)

# Define the tasks using PythonOperator
extract_task = PythonOperator(
    task_id='extract_task',
    python_callable=extract_task,
    provide_context=True,
    dag=dag,
)

transform_task = PythonOperator(
    task_id='transform_task',
    python_callable=transform_task,
    provide_context=True,
    dag=dag,
)

load_task = PythonOperator(
    task_id='load_task',
    python_callable=load_task,
    provide_context=True,
    dag=dag,
)

# Set task dependencies
extract_task >> transform_task >> load_task

if __name__ == "__main__":
    dag.cli()
