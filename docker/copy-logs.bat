@echo off

docker exec -it docker_caller_1 cat /opt/jboss/wildfly/standalone/log/server.log > logs\caller.log
docker exec -it docker_callee_master_1 cat /opt/jboss/wildfly/standalone/log/server.log > logs\callee_master.log
docker exec -it docker_callee_slave_1 cat /opt/jboss/wildfly/standalone/log/server.log > logs\callee_slave.log
docker exec -it docker_coordinator_backend_1 cat /opt/jboss/wildfly/standalone/log/server.log > logs\coordinator.log

pause