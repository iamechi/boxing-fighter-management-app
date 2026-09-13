#This is the build stage. It builds the java application using maven
FROM maven:3.9.16-amazoncorretto-17-alpine AS builder

#creates the working directory
WORKDIR /app-builder

#copies the project files from host directory to container project directory
COPY . /app-builder

#Runs the maven commands that handles the packaging and creation of the java.jar file
RUN mvn clean install

#Copies the jar file into the working directory for the staging and renames it
RUN cp /app-builder/target/*.jar /app-builder/fighter-management-app.jar

#This is the runner stage.
FROM amazoncorretto:17-alpine AS runner

#This sets the project directory for the runner stage
WORKDIR /app-runner

#This copies the jar file from the build stage to the app-runner directory
COPY --from=builder /app-builder/fighter-management-app.jar /app-runner

#runs the jar file
CMD ["java", "-jar", "fighter-management-app.jar"]