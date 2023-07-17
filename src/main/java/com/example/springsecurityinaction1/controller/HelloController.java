package com.example.springsecurityinaction1.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String Hello() {

        return "Hello!";
    }

    @GetMapping("/makeUser")
    public String makeUser() {
        UserDetails user = User.withUsername("username")
                .password("12345")
                .authorities("read", "write")
                .passwordEncoder(pw -> encode(pw))
                .accountExpired(false)
                .disabled(true)
                .build();
        return "user made !!! : " + user;
    }

    private String encode(String pw) {
        return null;
    }
}
