FROM openjdk:8-jdk-alpine
EXPOSE 80
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/desafio-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]