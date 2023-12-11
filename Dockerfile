FROM tomcat:9.0.83-jdk11-corretto
COPY /build/libs/SAC-1.0-SNAPSHOT.war /usr/local/tomcat
EXPOSE 8080
