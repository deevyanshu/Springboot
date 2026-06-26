package com.deevyanshu.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.validation.entitity.User;
import com.deevyanshu.validation.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User get(int id)
    {
        return userRepository.findById(id).get();
    }

    public User add(User u)
    {
        return userRepository.save(u);
    }
    
}
