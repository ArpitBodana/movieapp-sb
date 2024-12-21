FROM amazoncorretto:17

LABEL version="1.0"

WORKDIR /app

COPY target/commentservice-0.0.1-SNAPSHOT.jar /app/commentservice.jar

EXPOSE 9090:9090

ENTRYPOINT ["java","-jar", "commentservice.jar"]