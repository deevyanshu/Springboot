package com.deevyanshu.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    
}
