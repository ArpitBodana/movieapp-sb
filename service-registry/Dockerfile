FROM amazoncorretto:17

LABEL version = "1.0"

WORKDIR /app

COPY /target/service-registry-0.0.1-SNAPSHOT.jar /app/service-registry.jar

EXPOSE 8761:8761

ENTRYPOINT ["java","-jar","service-registry.jar"]
