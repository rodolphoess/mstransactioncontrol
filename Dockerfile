# Use a imagem oficial do OpenJDK 17 como base
FROM amazoncorretto:17

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY target/mstransactioncontrol-0.0.1-SNAPSHOT.jar mstransactioncontrol.jar

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "mstransactioncontrol.jar"]