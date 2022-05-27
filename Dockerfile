FROM maven:3.6.3-jdk-8-slim as build

WORKDIR /app

COPY src /app/src

COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package

FROM alpine:3.13

ENV MYSQL_HOST 10.0.224.16

ENV MYSQL_USERNAME music

ENV MYSQL_PASSWORD Music123456

ENV DATABASE_NAME meihua-music

RUN apk add --update --no-cache openjdk8-jre-base \
    && rm -rf /var/cache/apk/*

WORKDIR /app

COPY --from=build /app/target/meihua_music-0.0.1.jar .

EXPOSE 80

CMD ["java","-jar","/app/meihua_music-0.0.1.jar"]

