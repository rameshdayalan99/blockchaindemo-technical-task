FROM openjdk:8
WORKDIR /
ADD target/blockchaindemo.jar app.jar
EXPOSE  8080
ENTRYPOINT ["java", "-jar","blockchaindemo.jar"]
CMD ["app.jar"]
