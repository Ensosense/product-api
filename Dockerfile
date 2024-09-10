# Use multi-stage builds to optimize Docker images
# Stage 1: Build the application with Maven and cache dependencies
# Stage 2: Create a minimal final image with only the built artifact
# Docker caching reuses unchanged layers to speed up the build process

# Stage 1: Build Stage
FROM maven:3.8.6-openjdk-17 AS builder
# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src/ ./src/
RUN mvn package -DskipTests

# Stage 2: Runtime Stage
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/product-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your application will run on
EXPOSE 80

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
