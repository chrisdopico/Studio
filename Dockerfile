FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package
EXPOSE 8080
ENTRYPOINT ["java","-jar","studio.jar"]

#FROM openjdk:11
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} studio.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/studio.jar"]
