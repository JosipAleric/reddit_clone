# Build stage
FROM maven:3.8.7-openjdk-18 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Application stage
FROM openjdk:18-jdk-slim
COPY --from=build /home/app/target/reddit_clone-0.0.1-SNAPSHOT.jar /app/reddit-clone.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/reddit-clone.jar"]