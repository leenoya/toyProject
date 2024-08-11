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


# Kafka관련 차이점
1. Wurstmeister
   1. Kafka와 관련된 Docker 이미지를 제공하는 커뮤니티 프로젝트.
   2. 유지관리와 업데이트가 비교적 적음.(Kafka와 관련된 최신 기능들을 빠르게 적용되지 않음.)
   3. 커뮤니티에서 관리되므로, 일부 설정이나 기능이 최신 표준과 다를 수 있음.
   4. 유연성과 자유도가 높지만 그 만큼 기본 제공 기능이 제한적임.
2. Bitnami
   1. 상업적으로 지원하는 Docker이미지 제공자.
   2. 이미지가 정기적으로 업데이트 됨. 보안 패치와 새로운 버전이 빠르게 적용됨.
   3. Bitnami는 다양한 애플리케이션 스택을 지원하며, 배포와 표준화와 안정성에 중점을 둠.
   4. 다양한 환경 변수를 통해 더 세밀하게 구성 조정이 가능. 
   5. 미리 설정된 Best Practice를 따르기 때문에 초보자에게 쉽게 접근이 가능하도록 함.
