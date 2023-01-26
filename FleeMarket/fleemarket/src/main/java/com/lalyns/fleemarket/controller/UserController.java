package com.lalyns.fleemarket.controller;

import org.springframework.web.bind.annotation.*;

import com.lalyns.fleemarket.dto.users.request.RegistReq;
import com.lalyns.fleemarket.service.UserServiceInterface;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceInterface userService;

    @PostMapping(value="/register")
    public String registerUser
        (@RequestBody RegistReq request) {
        userService.createTestUser();        
        return "Success";
    }
    
}
