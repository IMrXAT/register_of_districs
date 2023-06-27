FROM openjdk:17
ADD target/register_of_districts-0.0.1-SNAPSHOT.jar register_of_districts-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","register_of_districts-0.0.1-SNAPSHOT.jar"]
