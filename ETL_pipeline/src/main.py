import json
import os, sys
current = os.path.dirname(os.path.realpath(__file__))
parent = os.path.dirname(current)
sys.path.insert(1, f"/{parent}/")
# Add two parent paths to sys.path
from common import utility as utls
utls.add_parent_paths(3)

import pandas as pd
import requests
import sqlalchemy as sa
# import mysql.connector
# API URL
api_url = "https://api.publicapis.org/entries"
# Establish a connection to the MySQL server
# connection = mysql.connector.connect(
#     host='localhost',
#     user='root',
#     password='root',
#     database='sakila'
# )
# Fetch data from the API
response = requests.get(api_url)
data = response.json()['entries']
# Convert the data to a Pandas DataFrame
df = pd.DataFrame(data)
print(df.sample())
# Metadata-driven configuration
metadata = {
    'target': {
        'database_uri': 'mysql+mysqlconnector://root:root@localhost:3306/sakila',
        'table_name': 'entries'
    }
}

# # Load data into the target database table
def load_to_database(data, database_uri, table_name):
    engine = sa.create_engine(database_uri)
    # data.to_sql(table_name, engine, if_exists='replace')
    data.to_csv("temp.csv",index=False)

# Load data into the target table
load_to_database(df, metadata['target']['database_uri'], metadata['target']['table_name'])
