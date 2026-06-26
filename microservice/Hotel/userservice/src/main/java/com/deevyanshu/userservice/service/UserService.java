package com.deevyanshu.userservice.service;

import java.util.List;

import com.deevyanshu.userservice.model.User;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAll();

    public User getUser(String id);
}
