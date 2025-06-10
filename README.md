# Spring Boot Async + CompletableFuture Demo

This is a minimal example project to demonstrate using `@Async` and `CompletableFuture` in a Spring Boot application.

Related blog post: [Boost Your Spring Boot App with @Async + CompletableFuture](#)  

## How to run

```
./mvnw spring-boot:run
```
Or run `AsyncDemoApplication.java` from your IDE.

## Test the endpoint

```
GET http://localhost:8080/api/parallel-tasks
```

## Features
- `@Async` method execution

- Parallel async calls with `CompletableFuture`

- Custom `ThreadPoolTaskExecutor` configuration

## License

MIT License

