package com.lalyns.fleemarket.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lalyns.fleemarket.dto.DefaultResponseEntity;
import com.lalyns.fleemarket.dto.users.request.LoginReq;
import com.lalyns.fleemarket.dto.users.request.RegistReq;
import com.lalyns.fleemarket.service.UserServiceInterface;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
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
