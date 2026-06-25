FROM eclipe-temurin:21-jkd-alpine
LABEL authors = "darkdestiny"
ARG JAR-FILE=target/MinInventario4BM2-0.0.1-SNAPSHOT.jar
COPY ${JAR-FILE} app_inventariomini.jar
EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app_inventariomini.jar"]
