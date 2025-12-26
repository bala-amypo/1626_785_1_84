// // package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import java.util.Date;
// import org.springframework.stereotype.Component;

// @Component
// public class JwtTokenProvider {

//     private final String secret;
//     private final long validityInMs;

//     public JwtTokenProvider(String secret, long validityInMs) {
//         this.secret = secret;
//         this.validityInMs = validityInMs;
//     }

//     // ✅ test needs this signature
//     public String generateToken(String email, String role, Long userId) {
//         Claims claims = Jwts.claims().setSubject(email);
//         claims.put("role", role);
//         claims.put("userId", userId);

//         Date now = new Date();
//         Date validity = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setIssuedAt(now)
//                 .setExpiration(validity)
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }
// }



package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(String email, String role, Long userId) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("role", role);
        claims.put("userId", userId);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
