package com.deevyanshu.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.userservice.model.User;
import com.deevyanshu.userservice.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/add")
    public User create(@RequestBody User user)
    {
        return userServiceImpl.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable String id)
    {
        return userServiceImpl.getUser(id);
    }

    @GetMapping("/getall")
    public List<User> getAll()
    {
        return userServiceImpl.getAll();
    }
    
}
