# ============================================
# Stage 1: Build
# ============================================
FROM eclipse-temurin:27-jdk AS builder

WORKDIR /app

# Copy Gradle wrapper and build files first # This improves Docker layer caching
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

RUN chmod +x gradlew

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build Spring Boot application
RUN ./gradlew bootJar --no-daemon


# ============================================
# Stage 2: Runtime
# ============================================
#FROM eclipse-temurin:27-jre
#for running jcmd using jdk for capturing heap dumps
FROM eclipse-temurin:27-jdk

WORKDIR /app

# Copy generated Spring Boot JAR
COPY --from=builder /app/build/libs/*.jar boot-profiler.jar

# Spring Boot default port
EXPOSE 8080

# Start application
ENTRYPOINT ["java", "-jar", "boot-profiler.jar"]