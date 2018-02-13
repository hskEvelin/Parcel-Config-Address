# Dockerfile

FROM ubuntu:16.04
RUN apt-get update ; apt-get dist-upgrade -y
RUN apt-get install -y openjdk-8-jre-headless

ADD /build/libs/Parcel-Config-Address-Pipeline-all-0.1.jar Parcel-Config-Address-Service.jar
CMD java -jar Parcel-Config-Address-Service.jar




