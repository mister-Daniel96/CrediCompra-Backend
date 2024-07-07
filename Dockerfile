FROM amazoncorretto:17-alpine-jdk
MAINTAINER TU ERES EL MEJOR!!!!
COPY target/CrediCompra-Backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]