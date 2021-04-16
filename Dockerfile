FROM openjdk:14
CMD ["mkdir", "app"]
WORKDIR app/
COPY target/demo.jar app/demo.jar
EXPOSE 8082
CMD ["java", "-jar", "app/demo.jar"]

