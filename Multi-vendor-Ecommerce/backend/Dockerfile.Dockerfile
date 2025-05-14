# Use an official Tomcat 9 image as base
FROM tomcat:9.0

# Clean default webapps to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the generated WAR file to the ROOT context (default)
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for external access
EXPOSE 8080

# Tomcat starts automatically – no CMD needed
