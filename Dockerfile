FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAVA_TOOL_OPTIONS="-Duser.country=BR -Duser.language=pt"
ADD target/integratjba-0.0.1.jar app_integratjba.jar
ENTRYPOINT ["java", "-jar", "/app_integratjba.jar"]
