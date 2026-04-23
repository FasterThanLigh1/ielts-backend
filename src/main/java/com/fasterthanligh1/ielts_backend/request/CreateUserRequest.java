package com.fasterthanligh1.ielts_backend.request;

public record CreateUserRequest(
        String email,
        String passwordHash,
        String firstName,
        String lastName
) {
}
