FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# give permission to mvnw
RUN chmod +x mvnw

# build project
RUN ./mvnw clean install -DskipTests

EXPOSE 8080

# run Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
