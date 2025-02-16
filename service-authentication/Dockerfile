FROM amazoncorretto:17

LABEL version="1.0"

WORKDIR /app

COPY /target/service-authentication-0.0.1-SNAPSHOT.jar /app/authservice.jar

EXPOSE 9097:9097

ENTRYPOINT ["java","-jar","authservice.jar"]