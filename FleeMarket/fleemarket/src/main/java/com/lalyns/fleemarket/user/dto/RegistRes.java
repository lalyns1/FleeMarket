package com.lalyns.fleemarket.user.dto;

import java.time.LocalDateTime;

import com.lalyns.fleemarket.user.entity.User;
import com.lalyns.fleemarket.user.entity.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistRes {
    private Long id;
    private String username;
    private UserRoleEnum role;

    public RegistRes res (User user){
        return RegistRes.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
