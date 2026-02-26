# ===========================================================
# Stage -1 Build the application
# ===========================================================

FROM maven:3.9.4-openjdk-11 AS builder

# Create working directory
WORKDIR /app

# Copy pom.xml
COPY pom.xml .

# Download all dependencies (this layer gets cached)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package

# ===========================================================
# Stage -2 Run the application
# ===========================================================

FROM openjdk:11-jre-slim

# Create the working directory
WORKDIR /app

# Copy the build jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 3000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

