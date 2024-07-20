# toyProject
Docker 사용을 위한 기본 설정
-
- docker pull mysql:8.0 (사용자 지정 Mysql Version)

Docker 실행 관련 명령어
- 
docker-compose up -d


# 기록용 명령어들
docker run -d --name mysqlDB -p 8888:3306 -e MYSQL_ROOT_PASSWORD=1234 mysql:8.0

체크 명령어 : docker network inspect mysql-network

docker exec -it mysqlDB mysql -u root -p (password : 1234)

create database dev;
