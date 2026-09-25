#base image
FROM amazoncorretto:17

#create directory
WORKDIR /app

#copy jar into image
COPY MicroserviceConfig-1.0.0.jar .

#document port
EXPOSE 7777

#init application java -jar MicroserviceConfig-1.0.0.jar
ENTRYPOINT ["java"]
CMD ["-jar", "MicroserviceConfig-1.0.0.jar"]