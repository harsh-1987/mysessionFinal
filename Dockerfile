FROM openjdk:11
EXPOSE 9090
ARG JAR_FILE=target/MySessionApplicationManagement.jar
ADD ${JAR_FILE} EcarePODFinal.jar
ENTRYPOINT ["java","-jar","/MySessionApplicationManagement.jar"]
