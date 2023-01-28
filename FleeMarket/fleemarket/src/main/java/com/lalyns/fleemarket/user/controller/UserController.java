package com.lalyns.fleemarket.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lalyns.fleemarket.util.statics.DefaultResponseEntity;

import lombok.RequiredArgsConstructor;

import com.lalyns.fleemarket.user.service.UserServiceInterface;
import com.lalyns.fleemarket.user.dto.*;



@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceInterface userService;

    @PostMapping(value = "/register")
    public ResponseEntity<Map<String, Object>> registerUser
        (@RequestBody RegistReq request) 
    {
        userService.registerUser(request);        
        return DefaultResponseEntity.setResponseEntity(null, "회원가입 성공", HttpStatus.OK);
    }
    
    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, Object>> login
        (@RequestBody LoginReq request,
        HttpServletResponse response) 
    {
        userService.login(request, response);
        return DefaultResponseEntity.setResponseEntity(null, "로그인 성공", HttpStatus.OK);
    }
}
