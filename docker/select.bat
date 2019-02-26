@echo off

echo "=== CALLER data ==="
docker exec -it docker_caller_db_1 su - oracle /opt/docker/select.sh

echo "=== CALLEE data ==="
docker exec -it docker_callee_db_1 su - oracle /opt/docker/select.sh

pause