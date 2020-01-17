FROM openjdk:11

ADD target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]