# Install pyenv for different version of python
https://codeburst.io/how-to-install-and-manage-multiple-python-versions-in-wsl2-1131c4e50a58
# Install docker for databases
echo 'export AIRFLOW_HOME=/home/srathod/workspace/airflow_home' >> ~/.bashrc
echo 'export SQLALCHEMY_SILENCE_UBER_WARNING=1' >> ~/.bashrc
echo 'export SPARK_HOME=/home/srathod/spark_home' >> ~/.bashrc
echo 'export PATH=$PATH:$SPARK_HOME/bin' >> ~/.bashrc
source ~/.bashrc
SQLALCHEMY_SILENCE_UBER_WARNING=1
CREATE DATABASE airflow_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'airflow_user' IDENTIFIED BY 'airflow_pass';
GRANT ALL PRIVILEGES ON airflow_db.* TO 'airflow_user';
GRANT ALL PRIVILEGES ON datadb.* TO 'airflow_user';
GRANT ALL PRIVILEGES ON exampledb.* TO 'airflow_user';
GRANT ALL PRIVILEGES ON metadatadb.* TO 'airflow_user';
export AIRFLOW_HOME=/home/srathod/workspace/airflow_home
export AIRFLOW_VERSION=2.5.2
export PYTHON_VERSION="$(python3 --version | cut -d " " -f 2 | cut -d "." -f 1-2)"
CONSTRAINT_URL="https://raw.githubusercontent.com/apache/airflow/constraints-${AIRFLOW_VERSION}/constraints-${PYTHON_VERSION}.txt"
# For example: https://raw.githubusercontent.com/apache/airflow/constraints-1.10.14/constraints-3.6.txt
pip install "apache-airflow[http,amazon,jdbc,kubernetes,celery,sendgrid]==${AIRFLOW_VERSION}" pymysql pymssql --constraint "${CONSTRAINT_URL}" -U --force
mysql+mysqldb://airflow_user:airflow_pass@localhost:3306/airflow_db
# create an admin user
airflow users create \
    --username admin \
    --firstname Peter \
    --lastname Parker \
    --role Admin \
    --email spiderman@superhero.org
airflow db init &&
airflow webserver -p 8083 -D &&
airflow scheduler -D
# Initilize docker and its corresponding services
sudo service docker start
sudo docker run hello-world
docker-compose -f /home/srathod/workspace/localstack/docker-compose.yaml up -d
source /home/srathod/workspace/.venv395/bin/activate
localstack start -d
sudo docker-compose -f /home/srathod/workspace/dumps/database/mysql/docker-compose.yaml up -d
# Initialize airflow
airflow db init
airflow scheduler -D
airflow webserver -p 8083 -D
#change the executor to below
executor = CeleryExecutor
Note: Make sure to use mysql or mssql as airflow_db (meaning RDBMS dbs only)
# aws
aws s3api create-bucket --bucket my-bucket --profile default --endpoint-url http://localhost:4566
aws s3api list-buckets --profile default --endpoint-url http://localhost:4566
aws ec2 run-instances --image-id ami-12345678 --count 1 --instance-type t2.micro --security-group-ids sg-12345678 --subnet-id subnet-12345678 --profile default --endpoint-url http://localhost:4566
aws --endpoint-url=http://localhost:4566 ec2 create-vpc --cidr-block 10.0.0.0/16
aws --endpoint-url=http://localhost:4566 ec2 create-subnet --vpc-id vpc-17e13599 --cidr-block 10.0.1.0/24
aws --endpoint-url=http://localhost:4566 ec2 create-internet-gateway
aws --endpoint-url=http://localhost:4566 ec2 attach-internet-gateway --vpc-id vpc-17e13599 --internet-gateway-id igw-c2a1dbc3
aws --endpoint-url=http://localhost:4566 ec2 create-route-table --vpc-id vpc-17e13599
aws --endpoint-url=http://localhost:4566 ec2 create-route --route-table-id rtb-611088e8 --destination-cidr-block 0.0.0.0/0 --gateway-id igw-c2a1dbc3'
aws --endpoint-url=http://localhost:4566 ec2 associate-route-table --subnet-id subnet-e5b9bfb9 --route-table-id rtb-611088e8
aws ec2 create-security-group --group-name my-sg --description "My security group" --vpc-id vpc-17e13599 --endpoint-url=http://localhost:4566
aws ec2 authorize-security-group-ingress --group-name my-sg --protocol tcp --port 22 --cidr 0.0.0.0/0 --endpoint-url=http://localhost:4566
aws ec2 run-instances --image-id ami-12345678 --count 1 --instance-type t2.micro --security-group-ids sg-729773012dea54746 --subnet-id subnet-12345678 --profile default --endpoint-url http://localhost:4566
docker run --rm -it -p 4566:4566 localstack/localstack
use next terminal
important url
https://docs.docker.com/engine/install/ubuntu/
https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04
https://codeburst.io/how-to-install-and-manage-multiple-python-versions-in-wsl2-1131c4e50a58
version: '3'
services:
  localstack:
    image: localstack/localstack:latest
    environment:
SERVICES=s3,ec2,rds,elb,lambda,dynamodb,apigateway,stepfunctions
DEFAULT_REGION=us-east-1
AWS_ACCESS_KEY_ID=test
AWS_SECRET_ACCESS_KEY=test
DEBUG=1
DATA_DIR=/tmp/localstack/data
PORT_WEB_UI=8080 # Setting port for the UI
    ports:
'4567:4566'
'4571:4571'
'8080:8080' # Forwarding UI port to host
    volumes:
'/var/run/docker.sock:/var/run/docker.sock'
'${TMPDIR:-/tmp/localstack}:/tmp/localstack'
version: '3'
services:
  mysql:
    image: mysql:5.7
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: "root"
    # command: mysqld --max_allowed_packet=256M
    command: --sql-mode=""