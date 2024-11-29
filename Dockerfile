FROM tomcat:10.1-jdk21

WORKDIR /usr/local/tomcat/webapps/

COPY target/*.war app.war
