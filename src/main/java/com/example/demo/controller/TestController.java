package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Test API", description = "Simple test endpoints")
public class TestController {

    @GetMapping("/api/test")
    @Operation(summary = "Get test message", description = "Returns a simple test message")
    public String getTest() {
        return "Swagger is working!";
    }

    @PostMapping("/api/test")
    @Operation(summary = "Post test message", description = "Accepts and returns a test message")
    public String postTest(@RequestBody String message) {
        return "Received: " + message;
    }
}