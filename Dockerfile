# Stage 1: Build
FROM maven:3.8.6-openjdk-17 AS builder

WORKDIR /app

# Copy the source code
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
