FROM openjdk:16-alpine3.13

EXPOSE 8080 8081

RUN addgroup -S atmfinder && adduser -S atmfinder -G atmfinder
WORKDIR /home/atmfinder/webapp
USER atmfinder


COPY --chown=atmfinder build/libs/atmfinder-*-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar