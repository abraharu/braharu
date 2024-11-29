FROM eclipse-temurin:21-jre

COPY target/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-war", "/app.war"]
