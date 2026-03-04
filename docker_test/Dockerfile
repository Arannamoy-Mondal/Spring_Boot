FROM eclipse-temurin:25 
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8001
ENTRYPOINT [ "java","-jar","app.jar" ]