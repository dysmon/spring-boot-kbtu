# Java version for base image
FROM eclipse-temurin:20-jdk-alpine

# Set the JAR file name
ARG JAR_FILE=target/*.jar

# Copy the JAR file into the container
COPY ./target/order-monolith-application-0.0.1-SNAPSHOT.jar app.jar

# Specify the command to run your application
ENTRYPOINT ["java", "-jar","/app.jar"]