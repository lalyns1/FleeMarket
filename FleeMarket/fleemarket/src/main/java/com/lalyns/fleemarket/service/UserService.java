package com.lalyns.fleemarket.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lalyns.fleemarket.dto.users.request.LoginReq;
import com.lalyns.fleemarket.dto.users.request.RegistReq;
import com.lalyns.fleemarket.dto.users.response.LoginRes;
import com.lalyns.fleemarket.dto.users.response.RegistRes;
import com.lalyns.fleemarket.entity.User;
import com.lalyns.fleemarket.repository.UserRepository;
// import com.lalyns.fleemarket.util.jwt.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;
    
    // private final JwtUtil jwtUtil;
    // private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public RegistRes registerUser(RegistReq request) {
        return new RegistRes();
    }

    @Override
    @Transactional // readOnly= true  하면 에러남
    public LoginRes login(LoginReq loginRequest, HttpServletResponse response) {  

        return new LoginRes();
    }
}
