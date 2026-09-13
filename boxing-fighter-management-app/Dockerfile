FROM amazoncorretto:17-alpine

WORKDIR /app

RUN mvn clean

RUN mvn package

RUN mvn install

COPY target/boxing-fighter-management-app-0.0.1-SNAPSHOT.jar /app/fighter-management-app.jar

CMD ["java", "-jar", "fighter-management-app.jar"]