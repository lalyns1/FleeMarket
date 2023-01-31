package com.lalyns.fleemarket.user.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lalyns.fleemarket.user.dto.LoginReq;
import com.lalyns.fleemarket.user.dto.RegistReq;
import com.lalyns.fleemarket.user.dto.LoginRes;
import com.lalyns.fleemarket.user.dto.RegistRes;
import com.lalyns.fleemarket.user.entity.User;
import com.lalyns.fleemarket.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;
    
    // private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public RegistRes registerUser(RegistReq request) {
        String username = request.getUsername();
        String password = passwordEncoder.encode(request.getPassword());

        if(existsByUsername(username)) {
            throw new IllegalArgumentException("해당 아이디("+username+")는 중복된 아이디입니다.");
        }

        User user = userRepository.saveAndFlush(new User(username, password));
        
        return new RegistRes().res(user);
    }

    @Override
    @Transactional // readOnly= true  하면 에러남
    public LoginRes login(LoginReq loginRequest, HttpServletResponse response) {  
        

        return new LoginRes();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkUsername(RegistReq request) {
        return existsByUsername(request.getUsername());
    }

    private boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
