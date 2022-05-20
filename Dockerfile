FROM openjdk:11

COPY target/giphy.jar /giphy-app.jar

CMD [ "java", "-jar", "/giphy-app.jar" ]