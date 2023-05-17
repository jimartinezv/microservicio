FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} Gateway-0.0.1-gateway.jar
ENTRYPOINT ["java", "-jar", "/Gateway-0.0.1-gateway.jar"]