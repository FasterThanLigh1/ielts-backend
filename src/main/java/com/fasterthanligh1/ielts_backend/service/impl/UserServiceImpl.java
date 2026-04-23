package com.fasterthanligh1.ielts_backend.service.impl;

import com.fasterthanligh1.ielts_backend.config.UserInfoDetails;
import com.fasterthanligh1.ielts_backend.entity.UserEntity;
import com.fasterthanligh1.ielts_backend.repository.UserRepository;
import com.fasterthanligh1.ielts_backend.request.CreateUserRequest;
import com.fasterthanligh1.ielts_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository repository;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database by email (username)
        Optional<UserEntity> userInfo = repository.findByEmail(username);

        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Convert UserInfo to UserDetails (UserInfoDetails)
        UserEntity user = userInfo.get();
        return new UserInfoDetails(user);
    }

    @Override
    public UserEntity createUser(CreateUserRequest request) {
        UserEntity user = new UserEntity();
        user.setEmail(request.email());
        user.setPasswordHash(request.passwordHash());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        repository.save(user);
        return user;
    }
}
