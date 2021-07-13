
FROM maven:3.6.0-jdk-11-slim AS maven_builder
WORKDIR /app
COPY ./ ./


RUN ["mvn","-v"]
RUN ["mvn","clean","install", "-Dmaven.test.skip=true"]
RUN ["mvn", "sonar:sonar" "-Dsonar.host.url=https://sonarqube.dsp4-5archio19-ah-je-gh-yb.fr", "-Dsonar.login=f3ff7b49060985dcd3d592299f9b76a6638e18ae"]

FROM tomcat:jdk11-corretto
COPY --from=maven_builder /app/target/theTipTop.war /usr/local/tomcat/webapps
CMD ["java", "-jar", "/usr/local/tomcat/webapps/theTipTop.war"]