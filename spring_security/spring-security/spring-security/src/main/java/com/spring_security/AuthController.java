package com.spring_security;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        // Normally you validate username/password with DB
        if (request.getUsername().equals("admin") && request.getPassword().equals("1234")) {
            return jwtUtil.generateToken(request.getUsername());
        }

        return "Invalid credentials";
    }
}
