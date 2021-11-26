FROM openjdk:8-jdk-alpine
VOLUME /tmp
expose 8080
ARG JAR_FILE=out/artifacts/representative_jar/representative.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]