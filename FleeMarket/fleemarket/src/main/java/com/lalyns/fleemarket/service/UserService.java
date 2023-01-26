package com.lalyns.fleemarket.service;

import org.springframework.stereotype.Service;

import com.lalyns.fleemarket.entity.User;
import com.lalyns.fleemarket.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public void createTestUser() {
        User testUser = User.builder()
                            .username("User1").password("1q2w3e4r").build();
                            
        userRepository.save(testUser);
    }
}
