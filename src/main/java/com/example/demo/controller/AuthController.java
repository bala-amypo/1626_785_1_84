package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "User registration and login operations")
public class AuthController {
    
    @PostMapping("/register")
    @Operation(
        summary = "Register User",
        description = "Register a new user account with unique email"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User registered successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "400", description = "Invalid user data or email already exists"),
        @ApiResponse(responseCode = "409", description = "Email already registered")
    })
    public User register(
        @Parameter(description = "User registration data", required = true)
        @RequestBody User user) {
        // Implementation will be added
        return user;
    }
    
    @PostMapping("/login")
    @Operation(
        summary = "User Login",
        description = "Authenticate user and return JWT token"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login successful",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "401", description = "Invalid credentials"),
        @ApiResponse(responseCode = "400", description = "Invalid login data")
    })
    public String login(
        @Parameter(description = "Login credentials", required = true)
        @RequestBody LoginRequest loginRequest) {
        // Implementation will be added
        return "{\"token\":\"jwt-token-here\"}";
    }
    
    public static class LoginRequest {
        private String email;
        private String password;
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}