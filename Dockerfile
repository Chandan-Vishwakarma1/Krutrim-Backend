# Use an official Java image
FROM openjdk:17-jdk-slim

# Set work directory
WORKDIR /app

# Copy built jar to the container
COPY target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
