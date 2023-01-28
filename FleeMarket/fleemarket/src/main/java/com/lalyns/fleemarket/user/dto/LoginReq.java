package com.lalyns.fleemarket.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReq {
    private String username;
    private String password;
}
