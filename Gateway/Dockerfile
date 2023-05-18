FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} gateway-0.0.2-gateway.jar
ENTRYPOINT ["java", "-jar", "/gateway-0.0.2-gateway.jar"]