
package com.foodwaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodwaste.dto.RegisterRequest;
import com.foodwaste.entity.User;
import com.foodwaste.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register User
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestBody RegisterRequest request) {

        User savedUser =
                authService.registerUser(request);

        return ResponseEntity.ok(savedUser);
    }
}

