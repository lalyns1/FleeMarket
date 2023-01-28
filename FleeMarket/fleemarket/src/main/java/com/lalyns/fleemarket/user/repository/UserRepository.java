package com.lalyns.fleemarket.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalyns.fleemarket.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
}
