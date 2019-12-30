
Spring Boot Zuul  and Eureka 
------------------------------
This example demonstrates the main features of the Zuul API gateway integrated into spring cloud :<br>
•	Service auto registration via eureka<br>
•	Service registration by address<br>
•	Service registration by service ID<br>
•	Filters (logging, authentication)<br>
•	Serving static content<br>
•	Service response Aggregation through Zuul<br><br>
Technology Used: <br>
•	Spring boot 1.5.3.RELEASE<br>
•	Eureka Service Discovery Client<br>
•	Zuul API Gateway<br><br>

Please review the attached POC project which contains two micro service (accountservice and nodeservice) , Service Discovery (eureka-server),  Api Gateway (zuul-server).

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Running Attached Project :

1.	Extract and you can find four maven projects 
2.	Run all the project with mvn clean install –Dmaven.test.skip=true spring-boot:run

Access the two micro service through the api gateway zuul-server (http://localhost:9090) : 

http://localhost:9090/api/account-by-service/account/login

http://localhost:9090/api/node-by-service/node/1

Service Discovery through the URL :
http://localhost:8761/

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Link followed for design :

http://microservices.io/patterns/microservices.html

https://dzone.com/articles/spring-cloud-netflix-zuul-edge-serverapi-gatewayga

https://www.nginx.com/blog/building-microservices-using-an-api-gateway/
