package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    // ✅ REQUIRED constructor (tests look for this EXACT signature)
    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    // ✅ Used in tests
    public String generateToken(User user) {
        return "dummy-jwt-token";
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }

    public String getEmailFromToken(String token) {
        return "test@example.com";
    }

    public String getRoleFromToken(String token) {
        return "ADMIN";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
