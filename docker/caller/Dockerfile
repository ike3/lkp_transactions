FROM jboss/wildfly

USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin 123qweASD --silent

CMD ["rm", "-rf", "/opt/jboss/wildfly/standalone/log"]

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug", "*:8787"]

EXPOSE 8080
EXPOSE 9990
EXPOSE 8787

# Enable XTS
RUN cp /opt/jboss/wildfly/docs/examples/configs/standalone-xts.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

# Oracle JDBC Driver
COPY com/oracle/main/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main/module.xml
COPY com/oracle/main/ojdbc6.jar /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main/ojdbc6.jar

# PGZDB
COPY driver.xml /opt/docker/driver.xml
COPY dataSource.xml /opt/docker/dataSource.xml
RUN sed -i '/<datasources>/r /opt/docker/dataSource.xml' /opt/jboss/wildfly/standalone/configuration/standalone.xml
RUN sed -i '/<drivers>/r /opt/docker/driver.xml' /opt/jboss/wildfly/standalone/configuration/standalone.xml

# External coordinator
RUN sed -i 's/<xts-environment url="http:\/\/${jboss.bind.address:127.0.0.1}:8080\/ws-c11\/ActivationService"\/>/<xts-environment url="http:\/\/coordinator5:8080\/ws-c11\/ActivationService"\/>/g' /opt/jboss/wildfly/standalone/configuration/standalone.xml

RUN sed -i 's/<core-environment node-identifier="${jboss.tx.node.id:1}">/<core-environment node-identifier="12">/g' /opt/jboss/wildfly/standalone/configuration/standalone.xml

# Logging
COPY logging.xml /opt/docker/logging.xml
RUN sed -i '/<\/periodic-rotating-file-handler>/r /opt/docker/logging.xml' /opt/jboss/wildfly/standalone/configuration/standalone.xml

