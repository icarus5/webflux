# Fase de construcción
FROM maven:3.8.6-openjdk-18-slim AS build
WORKDIR /app

# Instalar dependencias necesarias para clonar el repositorio
RUN apt-get update && apt-get install -y git

# Clonar el repositorio
RUN git clone URL_DEL_REPOSITORIO

# Copia el pom.xml y los archivos fuente al contenedor
COPY pom.xml .
COPY src ./src

# Construye la aplicación usando Maven
RUN mvn clean package

# Fase de ejecución
FROM openjdk:20
WORKDIR /app

# Copia el archivo JAR construido en la fase de construcción al contenedor de ejecución
COPY --from=build /app/target/simple-spring-application-0.0.1-SNAPSHOT.jar /usr/local/lib/my-app.jar

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/usr/local/lib/my-app.jar"]