package com.lalyns.fleemarket.service;

import javax.servlet.http.HttpServletResponse;

import com.lalyns.fleemarket.dto.users.request.*;
import com.lalyns.fleemarket.dto.users.response.*;

public interface UserServiceInterface {
    RegistRes registerUser(RegistReq request);
    LoginRes login(LoginReq request, HttpServletResponse response);

}
