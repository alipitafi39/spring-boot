package com.spring_security_role_based;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/info")
    public String userProfile() {
        return "account Profile - USER or ADMIN can access!";
    }
}
