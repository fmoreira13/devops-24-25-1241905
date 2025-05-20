FROM tomcat:10-jdk17-openjdk-slim

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN apt-get update && apt-get install -y git

RUN git clone https://github.com/fmoreira13/devops-24-25-1241905.git .

WORKDIR /usr/src/app/CA1/Part3/react-and-spring-data-rest-basic

RUN chmod +x gradlew
RUN ./gradlew bootWar

RUN cp ./build/libs/ROOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
