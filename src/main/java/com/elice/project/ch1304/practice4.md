```java
package com.elice.practice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private final String secretKey = "yourSecretKey";

    public String generateToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                // TODO: username을 subject로 설정하세요
                // TODO: 만료시간을 설정하세요 (1시간)
                // TODO: algorithm으로 서명하세요
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1시간 후 만료
                .sign(algorithm);

    }

    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
            // TODO: 토큰만료 exception을 감지하세요
        } catch (TokenExpiredException e) {
            // TODO: 토큰만료 시 true를 반환하세요
            return true; // 토큰 만료
        } catch (JWTVerificationException e) {
            return false; // 토큰 검증 실패
        }
    }
}
```
```java
package com.elice.practice.controller;

import com.elice.practice.service.TokenService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.auth0.jwt.JWT;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final TokenService tokenService;

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String token) {
        String username = JWT.decode(token).getSubject();

        // TODO: 토큰을 검증하고, 검증 성공 시 토큰을 재발급하세요
        if (tokenService.validateToken(token)) {
            return ResponseEntity.ok(tokenService.generateToken(username));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
    }
}
```