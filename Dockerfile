FROM tomcat:jdk11-corretto

ENV PATH_OF_WAR = $PATH_OF_WAR
RUN echo  $PATH_OF_WAR

COPY  $PATH_OF_WAR/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]