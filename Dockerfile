FROM tomcat:9.0.83-jdk11-corretto

# Copy the WAR file into the webapps directory of Tomcat
COPY build/libs/SAC-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
