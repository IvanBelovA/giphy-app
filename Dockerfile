FROM openjdk:11

COPY /giphy-appV1.jar /giphy-app.jar

CMD [ "java", "-jar", "/giphy-app.jar" ]