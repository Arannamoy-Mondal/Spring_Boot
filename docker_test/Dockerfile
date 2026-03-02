FROM eclipse-temurin:17-jre-jammy
RUN useradd -m springuser
USER springuser
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8001
ENTRYPOINT [ "java","-jar","/app.jar" ]