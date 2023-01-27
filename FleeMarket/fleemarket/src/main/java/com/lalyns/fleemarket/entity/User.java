package com.lalyns.fleemarket.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Entity(name="users")
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
