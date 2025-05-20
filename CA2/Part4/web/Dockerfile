FROM tomcat:10-jdk17-openjdk-slim

WORKDIR /usr/src/app/react-project

RUN apt-get update && apt-get install -y git

CMD ["bash", "-c", "chmod +x ./gradlew && ./gradlew build && catalina.sh run"]
