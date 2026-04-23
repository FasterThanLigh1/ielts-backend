package com.fasterthanligh1.ielts_backend.service;

import com.fasterthanligh1.ielts_backend.request.RegisterRequest;

public interface AuthService {
    void registerUser(RegisterRequest registerRequest);
}
