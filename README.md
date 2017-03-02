# batch-task-serializer
A demo to how to reproduce error http://stackoverflow.com/questions/42501901/spring-batch-restart-having-eureka-client-in-dependency


I found that to be able to reproduce the issue i should enable 

- spring-cloud-stream
- spring-cloud-client
- spring-batch
- spring-task

Run the project and then do a request to http://localhost:8080/execution/1 it should fail

Uncomment the batch at the top of dependency and comment it at bottom and retry the url above it will work.