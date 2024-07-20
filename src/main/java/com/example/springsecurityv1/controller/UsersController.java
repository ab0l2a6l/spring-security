package com.example.springsecurityv1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok("this is all users");
    }
}
