FROM eclipse-temurin:25.0.2_10-jdk-ubi10-minimal
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8001
CMD [ "java","-jar","app.jar" ]