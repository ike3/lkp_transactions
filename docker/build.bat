docker build --tag=lkp_transactions_caller caller
docker build --tag=lkp_transactions_callee callee
docker build --tag=lkp_transactions_coordinator coordinator
docker build --tag=lkp_transactions_nginx nginx

docker build --tag=lkp_transactions_logproxy logproxy

@echo off
rem
rem Просмотреть логи
rem 
rem docker exec -it docker_caller_1 cat /opt/jboss/wildfly/standalone/configuration/standalone.xml
rem 

rem
rem Просмотреть пакеты 
rem 
rem docker exec -it docker_callee_1 cat /tmp/bodies/0000000001
rem 

pause