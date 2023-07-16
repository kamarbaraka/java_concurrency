#base system
FROM eclipse-temurin:20-jdk
LABEL authors="kamar"

#run directory
RUN mkdir /java_concurrency

#copy from host to image
COPY target/ /java_concurrency

#directory to execute commands
WORKDIR /java_concurrency

#the command
CMD java ./classes/multithreading/TestTest