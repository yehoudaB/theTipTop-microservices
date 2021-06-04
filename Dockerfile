#!/bin/sh
FROM maven AS maven_builder
COPY ./ /
WORKDIR /

RUN ["mvn","-v"]
RUN ["mvn","clean","install", "-Dmaven.test.skip=true"]


FROM tomcat:jdk11-corretto
COPY --from=maven_builder /target/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]