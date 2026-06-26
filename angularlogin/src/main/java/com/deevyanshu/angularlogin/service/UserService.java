package com.deevyanshu.angularlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.deevyanshu.angularlogin.model.User;
import com.deevyanshu.angularlogin.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User get(String username)
    {
        return repository.getUserByUserName(username);
    }

    public User add(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_user");
        return repository.save(user);
    }
    
}
