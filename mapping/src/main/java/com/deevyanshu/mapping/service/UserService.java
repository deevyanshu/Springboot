package com.deevyanshu.mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.mapping.entity.User;
import com.deevyanshu.mapping.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User add(User user)
    {
        return userRepository.save(user);
    }

    public User get(int id)
    {
        return userRepository.findById(id).get();
    }
    
}
