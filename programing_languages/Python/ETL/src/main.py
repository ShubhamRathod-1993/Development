# Import necessary libraries
import pandas as pd
from sqlalchemy import create_engine
import requests
import json

# Metadata-driven configuration
metadata = {
    'api_source': {
        'url': 'https://api.example.com/data',
        'params': {'param1': 'value1', 'param2': 'value2'}
    },
    'sql_source': {
        'database_uri': 'postgresql://user:password@localhost:5432/database_name',
        'query': 'SELECT * FROM source_table'
    },
    'file_source': {
        'file_path': 'path/to/file.csv'
    },
    'target': {
        'database_uri': 'postgresql://user:password@localhost:5432/database_name',
        'table_name': 'target_table'
    }
}

# Extract data from API
def extract_from_api(url, params):
    response = requests.get(url, params=params)
    data = response.json()
    return data

# Extract data from SQL database
def extract_from_sql(database_uri, query):
    engine = create_engine(database_uri)
    data = pd.read_sql(query, engine)
    return data

# Extract data from a file
def extract_from_file(file_path):
    data = pd.read_csv(file_path)
    return data

# Data quality and cleansing functions (replace with your custom logic)
def data_quality_check(data):
    # Example: Check for missing values
    if data.isnull().any().any():
        raise ValueError("Data quality check failed: Missing values found")

def data_cleansing(data):
    # Example: Drop duplicates
    data.drop_duplicates(inplace=True)

# Transformation function (replace with your custom logic)
def transform(data):
    # Example: Convert column types
    data['date_column'] = pd.to_datetime(data['date_column'])
    return data

# Load data into target database
def load_to_database(data, database_uri, table_name):
    engine = create_engine(database_uri)
    data.to_sql(table_name, engine, index=False, if_exists='replace')

# Validate the loaded data (replace with your custom logic)
def validate_loaded_data(database_uri, table_name):
    engine = create_engine(database_uri)
    loaded_data = pd.read_sql(f'SELECT * FROM {table_name}', engine)

    # Example: Check if the number of rows match
    if len(loaded_data) != len(original_data):
        raise ValueError("Data validation failed: Number of rows mismatch")

# Main ETL process
if __name__ == '__main__':
    # Extract data from API
    api_data = extract_from_api(metadata['api_source']['url'], metadata['api_source']['params'])

    # Extract data from SQL
    sql_data = extract_from_sql(metadata['sql_source']['database_uri'], metadata['sql_source']['query'])

    # Extract data from file
    file_data = extract_from_file(metadata['file_source']['file_path'])

    # Combine data from different sources
    merged_data = pd.concat([api_data, sql_data, file_data], axis=1)

    # Data quality and cleansing
    data_quality_check(merged_data)
    data_cleansing(merged_data)

    # Transformation
    transformed_data = transform(merged_data)

    # Load to target database
    load_to_database(transformed_data, metadata['target']['database_uri'], metadata['target']['table_name'])

    # Validate loaded data
    validate_loaded_data(metadata['target']['database_uri'], metadata['target']['table_name'])
