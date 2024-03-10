FROM openjdk:8-jdk-alpine as builder
ADD . /src
WORKDIR /src
RUN ./mvnw package -DskipTests
EXPOSE 8090
ENTRYPOINT ["java","-jar","target/BootCompletableFuture-0.0.1-SNAPSHOT.jar"]