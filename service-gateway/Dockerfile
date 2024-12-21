FROM amazoncorretto:17

LABEL version="1.0"

WORKDIR /app

COPY target/service-gateway-0.0.1-SNAPSHOT.jar /app/service-gateway.jar

EXPOSE 9096:9096

ENTRYPOINT ["java","-jar","service-gateway.jar"]
