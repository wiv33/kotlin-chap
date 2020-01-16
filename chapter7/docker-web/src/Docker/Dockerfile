FROM openjdk:11

ADD target/*.jar docker-web.jar

ENTRYPOINT ["java", "-jar", "docker-web.jar"]