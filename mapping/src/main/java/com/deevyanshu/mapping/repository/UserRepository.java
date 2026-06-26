package com.deevyanshu.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.mapping.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
}
