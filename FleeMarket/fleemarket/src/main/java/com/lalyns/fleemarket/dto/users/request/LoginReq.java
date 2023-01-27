package com.lalyns.fleemarket.dto.users.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReq {
    private String username;
    private String password;
}
