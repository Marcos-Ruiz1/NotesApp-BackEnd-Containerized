#Base Layer
FROM openjdk:26-oraclelinux8
#Argument Var in case of non use it
#ARG JAR_FILE=target/*.jar
#Copy the build app 
COPY build/libs/Api-Backend-Notes-0.0.1-SNAPSHOT.jar app.jar
#Command to run the build app in the server
ENTRYPOINT ["java","-jar","/app.jar"]

##Command to build the image:
## command: docker build --build-arg JAR_FILE=build/libs/*.jar -t backendnotes-image:first .