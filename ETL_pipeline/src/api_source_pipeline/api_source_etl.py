import os, sys
current = os.path.dirname(os.path.realpath(__file__))
parent = os.path.dirname(current)
sys.path.insert(1, f"/{parent}/")
from src_utility import utility as src_utls
# Add two parent paths to sys.path
src_utls.add_parent_paths(3)
from common import utility as utls

etl_logger=utls.logger()
try:
    etl_logger.info("Setting up parameters")
    pass
except Exception as e:
    etl_logger.error(e)

class api_source:
    def __init__(self) -> None:
        # self.api_url = "https://www.apnewsarchive.com/search/"
        pass
    
import pandas as pd
import sqlalchemy as sa
import requests
import os

# Metadata-driven configuration
metadata = {
    'api_source': {
        'url': 'https://api.publicapis.org/entries',
        'params': {}
    },
    'sql_source': {
        'database_uri': 'mysql+mysqlconnector://root:root@localhost:3306/sakila',
        'query': 'SELECT * FROM address'
    },
    'file_source': {
        'file_path': '/home/srathod/workspace/ETL_pipeline/data/entry.csv'
    },
    'target': {
        'database_uri': 'mysql+mysqlconnector://root:root@localhost:3306/sakila',
        'table_name': 'target_table'
    }
}

# Step 1: Extract data from API
def extract_from_api(url, params):
    response = requests.get(url, params=params)
    response.raise_for_status()  # Raise an error for bad responses (4xx or 5xx)
    data = response.json()['entries']
    api_data_df = pd.DataFrame(data)
    return api_data_df

# Step 2: Extract data from SQL database
def extract_from_sql(database_uri, query):
    engine = sa.create_engine(database_uri)
    data = pd.read_sql(query, engine)
    return data

# Step 3: Extract data from a file
def extract_from_file(file_path):
    if not os.path.exists(file_path):
        raise FileNotFoundError(f"File '{file_path}' not found")
    data = pd.read_csv(file_path)
    return data

# Step 4: Data quality checks
def data_quality_checks(data):
    # Check for missing values
    # if data.isnull().any().any():
    #     raise ValueError("Data quality check failed: Missing values found")

    # # Check for duplicate rows
    # if data.duplicated().any():
    #     raise ValueError("Data quality check failed: Duplicate rows found")

    # # Check for negative values in numeric columns
    # numeric_cols = data.select_dtypes(include='number').columns
    # if (data[numeric_cols] < 0).any().any():
    #     raise ValueError("Data quality check failed: Negative values found in numeric columns")
    return data
    # Additional data quality checks can be added here

# Step 5: Data cleansing
def data_cleansing(data):
    # # Remove duplicates based on all columns
    # data = data.groupby(data.columns.tolist(), as_index=False).first()

    # # Remove leading and trailing whitespaces from string columns
    # string_cols = data.select_dtypes(include='object').columns
    # data[string_cols] = data[string_cols].apply(lambda x: x.str.strip() if x.dtype == 'O' else x)

    # # Convert text columns to lowercase
    # data[string_cols] = data[string_cols].apply(lambda x: x.str.lower() if x.dtype == 'O' else x)
    # Assuming 'column1' and 'column2' are the names of the columns you want to drop
    # data.drop(['location'], axis=1, inplace=True)

    # Additional data cleansing steps can be added here
    return data
# Step 6: Transformation
def transform(data):
    # Example: Convert column types
    # data['date_column'] = pd.to_datetime(data['date_column'])

    # Additional transformations can be added here

    return data

def convert_bytearray_column(df, col_name):
    df[col_name] = df[col_name].apply(lambda x: str(x, 'utf-8'))  # Example decoding
    return df

# Step 7: Load data into target database
def load_to_database(data, database_uri, table_name):
    # print(data.sample())
    engine = sa.create_engine(database_uri)
    # Create a connection
    conn = engine.connect()

    # Drop the table if it exists
    drop_table_statement = sa.text(f"DROP TABLE IF EXISTS {table_name};")
    conn.execute(drop_table_statement)
    # print(data.columns)
    data.to_sql(table_name, engine, index=False, if_exists='replace')
    # Close the connection
    conn.close()
    
# Step 8: Validate loaded data
def validate_loaded_data(database_uri, table_name):
    engine = sa.create_engine(database_uri)
    loaded_data = pd.read_sql(f'SELECT * FROM {table_name}', engine)

    # Example: Check if the number of rows match
    if len(loaded_data) != len(original_data):
        raise ValueError("Data validation failed: Number of rows mismatch")

    # # Check for consistency between columns
    # for col in loaded_data.columns:
    #     if col in original_data.columns:
    #         if not loaded_data[col].equals(original_data[col]):
    #             raise ValueError(f"Data validation failed: Column '{col}' values mismatch")

    # Additional validation steps can be added here

# Main ETL process
if __name__ == '__main__':
    # Step 1: Extract data from API
    api_data = extract_from_api(metadata['api_source']['url'], metadata['api_source']['params'])

    # Step 2: Extract data from SQL
    sql_data = extract_from_sql(metadata['sql_source']['database_uri'], metadata['sql_source']['query'])

    # Step 3: Extract data from file
    file_data = extract_from_file(metadata['file_source']['file_path'])

    # Step 4: Combine data from different sources
    merged_data = pd.concat([api_data, sql_data, file_data], axis=1)

    bytearray_cols = [
    col for col in merged_data.columns
    if merged_data[col].dtypes == 'object' and merged_data[col].dropna().apply(isinstance, args=(bytearray,)).any()
]


    for col in bytearray_cols:
        merged_data = convert_bytearray_column(merged_data, col)
    merged_data.drop_duplicates(inplace=True)
    # # Step 5: Data quality checks
    # data_quality_checks(merged_data)

    # # Step 6: Data cleansing
    # data_cleansing(merged_data)

    # Step 7: Transformation
    transformed_data = transform(merged_data)

    # Store the original data for validation
    original_data = transformed_data.copy()

    # Step 8: Load to target database
    
    load_to_database(transformed_data, metadata['target']['database_uri'], metadata['target']['table_name'])

    # Step 9: Validate loaded data
    validate_loaded_data(metadata['target']['database_uri'], metadata['target']['table_name'])
