package com.lalyns.fleemarket.dto.users.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistReq {
    private String username;
    private String password;
}
