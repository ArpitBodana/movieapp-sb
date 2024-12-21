FROM amazoncorretto:17

LABEL version="1.0"

WORKDIR /app

COPY /target/movieservice-0.0.1-SNAPSHOT.jar /app/movieservice.jar

EXPOSE 9095:9095

ENTRYPOINT ["java","-jar","movieservice.jar"]