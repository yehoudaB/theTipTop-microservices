FROM tomcat:jdk11-corretto
COPY  $PATH_OF_WAR/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]