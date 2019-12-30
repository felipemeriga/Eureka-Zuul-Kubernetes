FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/spring-cloud-eureka-example-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8761