// package com.example.demo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
// import org.springframework.web.bind.annotation.*;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.Parameter;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.responses.ApiResponses;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;

// @SpringBootApplication(exclude = {
//     DataSourceAutoConfiguration.class, 
//     HibernateJpaAutoConfiguration.class,
//     JpaRepositoriesAutoConfiguration.class
// }, scanBasePackages = {
//     "com.example.demo.config"
// })
// public class DemoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 	}

// 	@RestController
// 	@RequestMapping("/api")
// 	@Tag(name = "Demo API", description = "Demo endpoints for testing Swagger")
// 	static class SimpleController {
		
// 		@GetMapping("/health")
// 		@Operation(
// 			summary = "Health Check",
// 			description = "Returns the health status of the application"
// 		)
// 		@ApiResponses(value = {
// 			@ApiResponse(responseCode = "200", description = "Application is healthy",
// 				content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
// 		})
// 		public String health() {
// 			return "OK";
// 		}
		
// 		@PostMapping("/message")
// 		@Operation(
// 			summary = "Send Message",
// 			description = "Accepts a message and returns a confirmation"
// 		)
// 		@ApiResponses(value = {
// 			@ApiResponse(responseCode = "200", description = "Message received successfully",
// 				content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
// 			@ApiResponse(responseCode = "400", description = "Invalid message format")
// 		})
// 		public String sendMessage(
// 			@Parameter(description = "Message to be processed", required = true)
// 			@RequestBody String message) {
// 			return "Received: " + message;
// 		}
		
// 		@GetMapping("/user/{id}")
// 		@Operation(
// 			summary = "Get User",
// 			description = "Retrieves user information by ID"
// 		)
// 		@ApiResponses(value = {
// 			@ApiResponse(responseCode = "200", description = "User found",
// 				content = @Content(mediaType = "application/json")),
// 			@ApiResponse(responseCode = "404", description = "User not found")
// 		})
// 		public String getUser(
// 			@Parameter(description = "User ID", required = true)
// 			@PathVariable Long id) {
// 			return "{\"id\":" + id + ",\"name\":\"User " + id + "\"}";
// 		}
		
// 		@PostMapping("/user")
// 		@Operation(
// 			summary = "Create User",
// 			description = "Creates a new user with the provided information"
// 		)
// 		@ApiResponses(value = {
// 			@ApiResponse(responseCode = "201", description = "User created successfully",
// 				content = @Content(mediaType = "application/json")),
// 			@ApiResponse(responseCode = "400", description = "Invalid user data")
// 		})
// 		public String createUser(
// 			@Parameter(description = "User data in JSON format", required = true)
// 			@RequestBody String userData) {
// 			return "{\"message\":\"User created\",\"data\":" + userData + "}";
// 		}
// 	}
// }
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
