# Step 1: Use OpenJDK 21 as the base image
FROM openjdk:21-jdk-slim AS build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the Gradle wrapper and build scripts
COPY gradlew .
COPY gradle gradle

# Step 4: Copy the project files (including the build.gradle, settings.gradle, etc.)
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Step 5: Build the project (including the .jar file)
RUN chmod +x gradlew && ./gradlew build --no-daemon

# Step 6: Create the runtime image based on openjdk:21
FROM openjdk:21-jdk-slim

# Step 7: Set the working directory inside the container
WORKDIR /app

# Step 8: Copy the .jar file from the build image
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Step 9: Expose the port your Spring Boot application runs on
EXPOSE 8080

# Step 10: Run the application using the .jar file
CMD ["java", "-jar", "/app/app.jar"]
