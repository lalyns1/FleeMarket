package com.lalyns.fleemarket.user.service;

import javax.servlet.http.HttpServletResponse;

import com.lalyns.fleemarket.user.dto.*;

public interface UserServiceInterface {
    RegistRes registerUser(RegistReq request);
    LoginRes login(LoginReq request, HttpServletResponse response);

}
