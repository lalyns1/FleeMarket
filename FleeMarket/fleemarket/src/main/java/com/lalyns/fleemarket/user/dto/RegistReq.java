package com.lalyns.fleemarket.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistReq {
    private String username;
    private String password;
}
