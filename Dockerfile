# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application's jar file into the container
# COPY target/product-api-0.0.1-SNAPSHOT.jar app.jar
COPY ./target/product-api-*.jar app.jar


# Expose the port that your application will run on
EXPOSE 80

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

