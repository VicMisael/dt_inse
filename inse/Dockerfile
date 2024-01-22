FROM gradle:8.5-jdk17-focal AS BUILD
COPY . /usr/app
WORKDIR /usr/app
RUN gradle build -x test

FROM openjdk:17-alpine3.14
COPY --from=BUILD /usr/app/build/libs/inse-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "inse-0.0.1-SNAPSHOT.jar"]
