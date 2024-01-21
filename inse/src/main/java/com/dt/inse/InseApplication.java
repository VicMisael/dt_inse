package com.dt.inse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition
@CrossOrigin(origins = "http://localhost:3000")
public class InseApplication {
    public static void main(String[] args) {
        SpringApplication.run(InseApplication.class, args);
    }

}
