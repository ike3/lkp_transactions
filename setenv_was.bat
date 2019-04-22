@rem Change Path to your JDK
@echo off
@set JAVA_HOME=C:\was7\java
@set M2_HOME=C:\Java\apache-maven-3.2.5

@set PATH=%JAVA_HOME%\bin;%PATH%
@set MAVEN_OPTS=-XX:+UseParallelGC -Xmx1024m -XX:MaxPermSize=256m -Dhttps.protocols=TLSv1,SSLv3 -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -XX:+TieredCompilation -XX:TieredStopAtLevel=1

@rem Change path to your local maven repo
@set M2_PATH=C:\m2


@set SERVERNODE=fcsNode
@set SERVERCELL=fcsCell
@set SERVERNAME=fcsServer
@set USER=wasadmin
@set PASSWORD=wasadmin

@set WAS_ROOT=C:\was7\profiles\fcs
@set ADMIN=-conntype RMI -host localhost -port 2811 -lang jython -username %USER% -password %PASSWORD% -javaoption "-Xms1024m" -javaoption "-Xmx2048m"

@echo Env is set