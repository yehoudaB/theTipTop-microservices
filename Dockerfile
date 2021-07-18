
FROM maven:3.6.0-jdk-11-slim AS maven_builder
WORKDIR /app
COPY ./ ./


RUN ["mvn","-v"]
RUN ["mvn","clean","install", "-Dmaven.test.skip=true"]

FROM tomcat:jdk11-corretto
COPY --from=maven_builder /app/target/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]