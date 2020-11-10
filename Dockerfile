FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAVA_TOOL_OPTIONS="-Duser.country=BR -Duser.language=pt"
ADD target/integraedzatjba-0.3.6.jar app_integraedzatjba.jar
ENTRYPOINT ["java", "-jar", "/app_integraedzatjba.jar"]