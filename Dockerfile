# 1. Use Java base image
FROM eclipse-temurin:17-jdk-jammy

# 2. Set working directory
WORKDIR /app

# 3. Copy jar file into container
# (Make sure you build your project first → target/*.jar)
COPY target/*.jar app.jar

# 4. Expose port (same as server.port)
# EXPOSE 8080

# 5. Set environment variables (optional defaults)
# ENV GOOGLE_CLIENT_ID=""
# ENV GOOGLE_CLIENT_SECRET=""
# ENV GOOGLE_REDIRECT_URI=""
# ENV CORS_ALLOWED_ORIGINS="*"

# 6. Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]