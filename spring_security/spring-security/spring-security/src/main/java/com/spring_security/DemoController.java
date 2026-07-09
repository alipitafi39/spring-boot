package com.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/secure-data")
    public String secureData() {
        return "This is PROTECTED data accessed using JWT";
    }
}

