# Usar la imagen oficial de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Variables de entorno para la aplicación Java
ENV JAVA_OPTS=""

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el archivo jar de la aplicación al contenedor
COPY target/*.jar /app/rest-api.jar

# Entry point de la aplicación
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app/rest-api.jar" ]