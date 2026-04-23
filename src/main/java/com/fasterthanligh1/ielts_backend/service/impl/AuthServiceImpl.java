package com.fasterthanligh1.ielts_backend.service.impl;

import com.fasterthanligh1.ielts_backend.entity.UserEntity;
import com.fasterthanligh1.ielts_backend.request.CreateUserRequest;
import com.fasterthanligh1.ielts_backend.request.RegisterRequest;
import com.fasterthanligh1.ielts_backend.service.AuthService;
import com.fasterthanligh1.ielts_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        String encodedPassword = passwordEncoder.encode(registerRequest.password());

        CreateUserRequest request = new CreateUserRequest(
                registerRequest.email(),
                encodedPassword,
                registerRequest.firstName(),
                registerRequest.lastName()
        );

        UserEntity entity = userService.createUser(request);
        log.info("Successfully encoded password and initiated creation for user: {}", entity.getEmail());
    }
}
