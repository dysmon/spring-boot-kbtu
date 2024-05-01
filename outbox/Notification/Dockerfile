FROM eclipse-temurin:20-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Notification-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]