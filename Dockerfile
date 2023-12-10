FROM tomcat:9.0.83-jdk11-corretto

COPY WAR_FILE=build/libs/SAC-1.0-SNAPSHOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
