package com.fasterthanligh1.ielts_backend.controller;

import com.fasterthanligh1.ielts_backend.request.LoginRequest;
import com.fasterthanligh1.ielts_backend.request.RegisterRequest;
import com.fasterthanligh1.ielts_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok("Login successful for user: " + loginRequest.email());
    }

    @PostMapping("/register")
    ResponseEntity<Void> register(@Valid @RequestBody RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        return ResponseEntity.ok().build();
    }
}
