FROM openjdk:17-jdk-slim
COPY out/artifacts/spring_15_16_jar/spring-15-16.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]