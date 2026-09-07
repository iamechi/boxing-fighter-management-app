<h1>#K.O. Time Flow Fighter Management Java Spring Boot Application</h1>
<br/>
This is the fighter management Spring Boot microservice that was created for the K.O. application. It lets you add and update fighters to the database. This will help us keep track of the fighters we have in the system, what their record is, where they reside, and their weight and height, all of which are factors that are important for scheduling fighters for different fights as it tells which fights a fighter is suited to take or is capable of making or not making due to transportation logistics and barriers. The current state that it is in right now is just the first phase as there will be additional enhancements and bug fixes for additional features such as adding a column to the screen that will signal that a fighter has been booked for a fight and one for if he is currently active, retired, or injured.<br/> 
As mentioned in the title, this is a Java Spring Boot application. The design of this application follows a DAO model, meaning there is:<br/>
<ul>
  <li>a fighter class that models the database table</li>
  <li>a repository class that extends to JpaRepository and JpaSpecificationExecutor classes so we can use the built methods that easily handles the retrieving data from the database</li>
  <li>a DAO service class that acts in between for the repository and controller class and handles search criteria logic for the database</li>
  <li>a controller class that mainly handles the business logic for the application</li>
</ul>
<br/>
There is also a application.properties file is what sets up the connection between the Spring Boot application and AWS RDS instance where the database is being hosted on. Maven build tools were used to clean, compile, and package this project into a .jar file. A Dockerfile was also used to build an image that will create a docker container for this microservice application. Furthermore, this Java Project follows a REST API, meaning it relies on HTTP requests to send and retrieve data from the front-end.
<br/>
The design of this application will be used as a template to build the other microservice applications, so it will be an important microservice outside of it's functionality. Therefore, it's development is very pivotal to the entirety of this project, as it will serve as a guide to build further microservices in the future. 
