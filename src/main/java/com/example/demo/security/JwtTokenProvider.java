package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    
    public String generateToken(String email, String role, Long userId) {
        return email + ":" + role + ":" + userId;
    }

    public boolean validateToken(String token) {
        return token != null && !token.trim().isEmpty();
    }

    public String getEmailFromToken(String token) {
        if (token != null && token.contains(":")) {
            return token.split(":")[0];
        }
        return null;
    }

    public String getRoleFromToken(String token) {
        if (token != null && token.contains(":")) {
            String[] parts = token.split(":");
            return parts.length > 1 ? parts[1] : null;
        }
        return null;
    }
}
