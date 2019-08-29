mkdir /opt/docker

### vi Dockerfile
# Pull base image 
From tomcat:8-jre8 

# Maintainer
MAINTAINER "nitikavi" 

# copy war file on to container 
COPY ./eduapp.war /usr/local/tomcat/webapps