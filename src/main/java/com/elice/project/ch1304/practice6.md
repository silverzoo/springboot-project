```java
package com.elice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    // final 글로벌 변수선언
    private String secretKey = "eliceSecretKey";
    private long expirationTime = 3600000;

    public String generateToken(String username) {
        // 지시사항을 참고하여 코드를 작성해 보세요.
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(algorithm);
    }

    public boolean validateToken(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return !jwt.getExpiresAt().before(new Date());
    }

    public String getUsernameFromToken(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getSubject();
    }

    // 실제 애플리케이션에서는 이 메서드를 데이터베이스나 다른 인증 시스템과 연동해야 합니다.
    public boolean authenticateUser(String username, String password) {
        // 예시 목적으로 간단한 검증만 수행합니다.
        return "admin".equals(username) && "password".equals(password);
    }
}
```
```java
package com.elice.controller;

import com.elice.service.TokenService;
import lombok.*;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        //지시사항을 참고하여 코드를 작성해 보세요.
        try {
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword(); 

            // 실제 애플리케이션에서는 여기서 사용자 인증을 수행해야 합니다.
            if (!tokenService.authenticateUser(username, password)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }

            String token = tokenService.generateToken(username);
            return ResponseEntity.ok(new TokenResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login: " + e.getMessage());
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<?> accessProtectedResource(@RequestHeader("Authorization") String token) {
        try {
            if (tokenService.validateToken(token)) {
                String username = tokenService.getUsernameFromToken(token);
                return ResponseEntity.ok("Access granted to protected resource for user: " + username);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
            }
        } catch (JWTVerificationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token verification failed: " + e.getMessage());
        }
    }



    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class LoginRequest {
        private String username;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    public static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }
    }
}
```
