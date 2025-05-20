FROM tomcat:10-jdk17-openjdk-slim

# Cria diretório de trabalho
WORKDIR /usr/src/app

# Instala Git (se necessário)
RUN apt-get update && apt-get install -y git

# Copia o projeto do host (ajuste o caminho conforme necessário)
COPY ../../CA1/Part3/react-and-spring-data-rest-basic/ ./

# Dá permissão de execução ao gradlew
RUN chmod +x ./gradlew

# Compila o projeto
RUN ./gradlew build

# Executa o Tomcat
CMD ["catalina.sh", "run"]
