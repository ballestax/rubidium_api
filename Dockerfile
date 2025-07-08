# Stage 1: Build the application (using a full JDK image)
FROM openjdk:21-jdk-slim-bullseye AS build

# Install utilities (curl for download, and potentially other build essentials)
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl gnupg dirmngr && \
    rm -rf /var/lib/apt/lists/*

# Install Maven
ENV MAVEN_VERSION 3.9.6
ENV MAVEN_HOME /opt/maven
ENV PATH ${MAVEN_HOME}/bin:${PATH}

# Corrección aquí: Eliminar el comentario de la URL y corregir MAEN_VERSION a MAVEN_VERSION
RUN curl -fSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -o /tmp/apache-maven.tar.gz && \
    tar -xzf /tmp/apache-maven.tar.gz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    rm -f /tmp/apache-maven.tar.gz

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml and source code)
COPY pom.xml .
COPY src ./src

# Package the application into an executable JAR
RUN mvn clean package -DskipTests -f pom.xml

# Stage 2: Create the final lightweight image (using only JRE)
FROM openjdk:21-slim-bullseye

# Set the working directory
WORKDIR /app

# Copy the built JAR from the 'build' stage to the final image
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on (8081)
EXPOSE 8081

# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]