FROM openjdk:11 -alpine
EXPOSE 9000
ARG JAR_FILE=target/EcarePOD.jar
ADD ${JAR_FILE} MySqlDemo.jar
ENTRYPOINT ["java","-jar","/MySqlDemo.jar"]
