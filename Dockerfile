FROM openjdk:8-jdk-alpine

COPY ./target/my-utility-portal.jar ./my-utility-portal.jar
ENTRYPOINT ["java","-jar","/my-utility-portal.jar"]