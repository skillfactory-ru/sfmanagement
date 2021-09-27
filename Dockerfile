FROM openjdk:11.0.7-jre-slim
COPY /target service.jar
CMD java $JAVA_OPTS -jar /service.jar
EXPOSE 8080