# Utiliza la imagen oficial de OpenJDK como imagen base
FROM openjdk:20

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /AMES_TechnicalTest

# Copia el JAR de la aplicación de Spring Boot al contenedor
COPY target/provatecnica-0.0.1-SNAPSHOT.jar provatecnica-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que la aplicación de Spring Boot escucha (por ejemplo, 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación de Spring Boot
CMD ["java", "-jar", "provatecnica-0.0.1-SNAPSHOT.jar"]