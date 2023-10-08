
FROM openjdk:11-jre-slim

# Variável de ambiente para armazenar o nome do arquivo JAR
#(Como o nome pode mudr, deixei aqui para facilitar)
ENV JAR_FILE CarteiraDeInvestimentos-0.0.1-SNAPSHOT.jar

# Copia o arquivo JAR da aplicação para o contêiner
COPY build/libs/$JAR_FILE /app.jar

# Porta em que sua aplicação Spring Boot escuta
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "/app.jar"]
