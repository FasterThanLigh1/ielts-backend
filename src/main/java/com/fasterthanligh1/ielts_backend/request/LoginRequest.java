package com.fasterthanligh1.ielts_backend.request;

public record LoginRequest(
        String email,
        String password
) {
}
