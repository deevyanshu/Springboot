package com.deevyanshu.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.validation.entitity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
}
