FROM wnameless/oracle-xe-11g

# Database scripts
COPY init.sql /docker-entrypoint-initdb.d/
RUN chmod -R +x /docker-entrypoint-initdb.d

COPY select.sh /opt/docker/select.sh
RUN chmod +x /opt/docker/select.sh
