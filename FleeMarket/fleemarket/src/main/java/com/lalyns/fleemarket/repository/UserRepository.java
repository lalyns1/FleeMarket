package com.lalyns.fleemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalyns.fleemarket.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
