# TheTipTop-microservices

Look at http://domain/swagger-ui/ or http://domain/api/api-docs endpoints to find the api endpoints

## Run localy
for running the microservice localy execute :
```
	 "mvn clean install -Plocal"
```	 
*You need to have a web server and mysql server running (and check if the ports match with the application-local.properties)*



## Run on prod	 
for running the microservice with docker in production execute :
```	
	docker-compose --env-file ./environements/.env.prod up -d
```

## Run on dev
and for developement execute :
```
	 docker-compose --env-file ./environements/.env.dev up
```	 
		 
*the ".env.dev" and ".env.prod" files are  ignored by git for safety reasons* 

*look at the ".env.example" file to help you create these files*
 

