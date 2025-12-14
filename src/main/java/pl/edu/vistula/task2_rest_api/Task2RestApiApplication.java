package pl.edu.vistula.task2_rest_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Product REST API",
                version = "1.0",
                description = "Task 2 – Spring Boot REST API"
        )
)
public class Task2RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Task2RestApiApplication.class, args);
    }
}
