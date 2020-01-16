FROM openjdk:11

ADD maven/*.jar docker-web.jar

ENTRYPOINT ["java", "-jar", "docker-web.jar"]