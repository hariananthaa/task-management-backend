FROM openjdk:17

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} project-service.jar

ENTRYPOINT ["java", "-jar", "/project-service.jar"]

EXPOSE 8092