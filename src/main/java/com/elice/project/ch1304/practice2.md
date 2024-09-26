```java
package com.elice.controller;

import com.elice.entities.Otp;
import com.elice.entities.User;
import com.elice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<Map<String, String>> registerUser(@Valid @RequestBody User user) {
        try {
            userService.addUser(user);
            Map<String, String> response = new HashMap<>();
            response.put("message", "User registered successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to register user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<Map<String, String>> authenticateUser(@RequestBody User user) {
        try {
            Optional<User> authenticatedUser = userService.auth(user);
            if (authenticatedUser.isPresent()) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "User authenticated successfully");
                response.put("username", authenticatedUser.get().getUsername());
                return ResponseEntity.ok(response);
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Authentication failed");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
            }
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Authentication failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    @PostMapping("/otp/generate")
    public ResponseEntity<Map<String, String>> generateOtp(@RequestBody User user) {

        try {
            String otp = userService.generateAndSaveOtp(user.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("message", "OTP generated successfully");
            response.put("otp", otp);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to generate OTP: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PostMapping("/otp/validate")
    public ResponseEntity<Map<String, String>> validateOtp(@RequestBody Otp otp) {
        //지시사항을 참고하여 코드를 작성해 보세요.
        boolean isValid = userService.check(otp);
        Map<String, String> response = new HashMap<>();
        if (isValid) {
            response.put("message", "OTP validated successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid OTP");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "An unexpected error occurred: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```
```java
package com.elice.service;

import com.elice.entities.Otp;
import com.elice.entities.User;
import com.elice.repository.OtpRepository;
import com.elice.repository.UserRepository;
import com.elice.utils.GenerateCodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final OtpRepository otpRepository;

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> auth(User user) {
        Optional<User> o = userRepository.findUserByUsername(user.getUsername());

        if(o.isPresent()) {
            User u = o.get();
            if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                renewOtp(u);
            } else {
                throw new BadCredentialsException("Bad credentials.");
            }

            return o;
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }

    public boolean check(Otp otpToValidate) {
        //지시사항을 참고하여 코드를 작성해 보세요.
        Optional<Otp> userOtp = otpRepository.findOtpByUsername(otpToValidate.getUsername());
        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();
            return otpToValidate.getCode().equals(otp.getCode());
        }

        return false;
    }

    private void renewOtp(User u) {
        String code = GenerateCodeUtil.generateCode();

        Optional<Otp> userOtp = otpRepository.findOtpByUsername(u.getUsername());
        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();
            otp.setCode(code);
        } else {
            Otp otp = new Otp();
            otp.setUsername(u.getUsername());
            otp.setCode(code);
            otpRepository.save(otp);
        }
    }

    public String generateAndSaveOtp(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            String code = GenerateCodeUtil.generateCode();

            Optional<Otp> existingOtp = otpRepository.findOtpByUsername(username);
            if (existingOtp.isPresent()) {
                Otp otp = existingOtp.get();
                otp.setCode(code);
            } else {
                Otp newOtp = new Otp();
                newOtp.setUsername(username);
                newOtp.setCode(code);
                otpRepository.save(newOtp);
            }

            return code;
        } else {
            throw new BadCredentialsException("User not found.");
        }
    }
}
```