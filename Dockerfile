FROM tomcat:jdk11-corretto

ARG PATH_OF_WAR  ${PATH_OF_WAR}
ARG PATH_OF_WAR  $PATH_OF_WAR
RUN echo  PATH_OF_WAR
RUN echo  ${PATH_OF_WAR}

COPY  $PATH_OF_WAR/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]