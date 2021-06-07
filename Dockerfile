FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=target/MySessionApplicationManagement.jar
ADD ${JAR_FILE} EcarePOD.jar
ENTRYPOINT ["java","-jar","/EcarePOD.jar"]


