package com.deevyanshu.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.jpa.entity.User;
import com.deevyanshu.jpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
       return userRepository.save(user);
    }

    @Override
    public User get(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(int id,User user) {
       User user1=get(id);
       user1.setCity(user.getCity());
       user1.setName(user.getName());
       user1.setStatus(user.getStatus());
       return userRepository.save(user1);
    }

    @Override
    public User delete(int id) {
        User user=get(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }
    
}
