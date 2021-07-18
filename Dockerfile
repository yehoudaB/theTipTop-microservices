
FROM maven:3.6.0-jdk-11-slim AS maven_builder
WORKDIR /app
COPY ./ ./


RUN ["mvn","-v"]
RUN ["mvn","clean","install", "-Dmaven.test.skip=true"]

RUN ["mvn","sonar:sonar", " -Dsonar.projectKey=theTipTop_microservice", " -Dsonar.host.url=https://sonarqube.dsp4-5archio19-ah-je-gh-yb.fr","  -Dsonar.login=tokenb", "-Dsonar.sources=.", " -Dsonar.language=java"]

FROM tomcat:jdk11-corretto
COPY --from=maven_builder /app/target/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]