# mutants

Two types of profile are being used: 
Dev: You will be using a Standalone Redis Config. In this case you will need to have Redis running in your local machine or your docker to provide one for you. 
Prod: You will be using a Cluster Redis Config. In this case you will need to set redis.master in application-prod.properties and point it to
your ElasticCache cluster endpointer if you are using AWS.

Depending on your local environemtn you will need the following comamnds:
mvn spring-boot:run -P dev
mvn package -Dmaven.test.skip=true  -P prod

Tests:
13 tests where provided. In this case you will not need to run your own Redis. Once is provided for you. The whole SpringBootUp will start at random port. 
