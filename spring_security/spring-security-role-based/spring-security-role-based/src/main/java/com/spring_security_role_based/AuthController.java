package com.spring_security_role_based;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        // Fake in-memory users for demo:
        if (request.getUsername().equals("admin") && request.getPassword().equals("1234")) {
            return jwtUtil.generateToken("admin", List.of("ROLE_ADMIN"));
        }
        if (request.getUsername().equals("user") && request.getPassword().equals("1234")) {
            return jwtUtil.generateToken("user", List.of("ROLE_USER"));
        }

        return "Invalid credentials";
    }
}
