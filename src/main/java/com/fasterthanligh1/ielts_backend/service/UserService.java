package com.fasterthanligh1.ielts_backend.service;

import com.fasterthanligh1.ielts_backend.entity.UserEntity;
import com.fasterthanligh1.ielts_backend.request.CreateUserRequest;

public interface UserService {
    UserEntity createUser(CreateUserRequest request);
}
