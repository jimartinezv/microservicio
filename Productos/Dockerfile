FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} Productos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Productos-0.0.1-SNAPSHOT.jar"]