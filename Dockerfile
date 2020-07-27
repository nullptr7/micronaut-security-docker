FROM openjdk:14-alpine
COPY target/micronaut-security-docker-*.jar micronaut-security-docker.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-security-docker.jar"]