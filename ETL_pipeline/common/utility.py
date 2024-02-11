import configparser
import logging
import os, sys
import traceback
import numpy as np
current = os.path.dirname(os.path.realpath(__file__))
parent = os.path.dirname(current)
sys.path.insert(1, f"{parent}/")

config_file_path=parent+'/config.ini'

def add_parent_paths(levels):
    current = os.path.dirname(os.path.realpath(__file__))
    for _ in range(levels):
        current = os.path.dirname(current)
        sys.path.insert(1, f"{current}")

# Add three parent paths to sys.path
add_parent_paths(3)

import sqlalchemy as sa

def read_config(file_path=config_file_path):
    """
    The read_config function reads the config file and returns a ConfigParser object.

    :param file_path: Specify the path to the config file
    :return: A configparser object
    :doc-author: Shubham R.
    """
    config = configparser.ConfigParser()
    config.read(file_path)
    return config

def logger(log_file_path='app.log', log_file_flg='N'):
    """
    The logger function is a simple wrapper around the logging module.
    It creates a logger object and sets it to DEBUG level, then adds a console handler
    and sets that to DEBUG level as well. It also adds a file handler to log to a file.

    :param log_file_path: Path to the log file, default is 'app.log'
    :return: A logger object
    :doc-author: Shubham R.
    """
    # create logger
    logger = logging.getLogger()
    logger.setLevel(logging.DEBUG)

    # Check if a console handler already exists
    console_handlers = [h for h in logger.handlers if isinstance(h, logging.StreamHandler)]
    if not console_handlers:
        # create console handler and set level to debug
        ch = logging.StreamHandler()
        ch.setLevel(logging.DEBUG)

        # create formatter
        formatter = logging.Formatter('%(asctime)s | %(name)s | %(funcName)s:%(lineno)d | %(levelname)s | %(message)s')

        # add formatter to handler
        ch.setFormatter(formatter)

        # add handler to logger
        logger.addHandler(ch)

    if log_file_flg.upper() == 'Y':
        # Check if the file exists and handle file creation logic
        if os.path.exists(log_file_path):
            file_size = os.path.getsize(log_file_path)
            if file_size > 1 * 1024 * 1024:
                os.remove(log_file_path)

            with open(log_file_path, "w") as file:
                file.write("")
        else:
            with open(log_file_path, "w") as file:
                file.write("")

        # Check if a file handler already exists
        file_handlers = [h for h in logger.handlers if isinstance(h, logging.FileHandler)]
        if not file_handlers:
            # create file handler and set level to debug
            fh = logging.FileHandler(log_file_path)
            fh.setLevel(logging.DEBUG)
            fh.setFormatter(formatter)
            logger.addHandler(fh)

    return logger

# Use the logger function to create a logger object
etl_logger = logger()




def create_database_engine(db_type, **kwargs):
    """
    Create and return a SQLAlchemy engine based on the specified database type.
    
    Supported database types: 'sqlite', 'mysql', 'postgresql', 'mssql', 'oracle', 'snowflake'
    
    :param db_type: Database type (e.g., 'sqlite', 'mysql', 'mssql', 'oracle', 'snowflake')
    :param kwargs: Additional keyword arguments for creating the engine
    :return: SQLAlchemy engine
    """
    supported_db_types = ['sqlite', 'mysql', 'postgresql', 'mssql', 'oracle', 'snowflake']

    if db_type not in supported_db_types:
        raise ValueError(f"Unsupported database type: {db_type}. Supported types: {', '.join(supported_db_types)}")

    connection_string = kwargs.pop('connection_string', None)

    if db_type == 'sqlite':
        engine = sa.create_engine(f'sqlite:///{connection_string}', **kwargs)
    elif db_type == 'mysql':
        engine = sa.create_engine(f'mysql://{connection_string}', **kwargs)
    elif db_type == 'postgresql':
        engine = sa.create_engine(f'postgresql://{connection_string}', **kwargs)
    elif db_type == 'mssql':
        engine = sa.create_engine(f'mssql+pyodbc://{connection_string}', **kwargs)
    elif db_type == 'oracle':
        engine = sa.create_engine(f'oracle://{connection_string}', **kwargs)
    elif db_type == 'snowflake':
        engine = sa.create_engine(f'snowflake://{connection_string}', **kwargs)
    else:
        raise ValueError(f"Unsupported database type: {db_type}")

    return engine
# 'user:password@localhost:3306/your_database'
# Example usage:
# db_type = 'sqlite'
# connection_string = '/path/to/sqlite/database.db'
# engine = create_database_engine(db_type, connection_string=connection_string)

# Now 'engine' is a SQLAlchemy engine for the specified database type
# db_type = 'mysql'
# connection_string = 'root:root@localhost:3306/sakila'
# engine = create_database_engine(db_type, connection_string=connection_string)

def save_df(connection_uri, df, table):
    """
    The save_df_mssql function takes a dataframe, strips leading and trailing spaces from all columns, sets columns with length 0 to None, and then loads the data into a table in SQL Server.
    
    :param connection_uri: Connect to the database
    :param df: Pass in the dataframe that you want to save
    :param table: Specify the table name and schema (if applicable) to load the data into
    :return: The number of rows loaded to the table
    :doc-author: Shubham R.
    """
    try:
        engine = sa.create_engine(connection_uri)
        # schema_name = table.split('.')[0]
        table_name = table

        with engine.begin() as conn:
            if df.shape[0] > 0:
                for col in df.columns:
                    if df[col].dtype == np.int64:
                        df[col] = df[col].astype(int)
                # Strip leading and trailing spaces from all columns
                df = df.apply(lambda x: x.strip() if isinstance(x, str) else x)
                # Set columns with length 0 to None
                df = df.apply(lambda x: None if isinstance(x, str) and len(x) == 0 else x)

                df.to_sql(name=table_name, con=engine, if_exists="replace", index=False)
                loaded_count = len(df.index)
                etl_logger.info(f"{loaded_count} records loaded to {table}")
                return loaded_count
            else:
                etl_logger.info(f"no valid records for {table}")
    except Exception as e:
        # Print the faulty record if necessary
        etl_logger.info(str(e) + '\n' + str(traceback.extract_tb(e.__traceback__)))