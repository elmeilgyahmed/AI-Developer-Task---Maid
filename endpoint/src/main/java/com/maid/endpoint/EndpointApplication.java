package com.maid.endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Indicates that this class is the main entry point for a Spring Boot application
public class EndpointApplication {

    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(EndpointApplication.class, args);
    }

}
