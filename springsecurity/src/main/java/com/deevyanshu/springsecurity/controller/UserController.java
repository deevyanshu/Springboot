package com.deevyanshu.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.springsecurity.model.User;
import com.deevyanshu.springsecurity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getall()
    {
        return userService.getall();
    }

    @GetMapping("/{name}")
    public User get(@PathVariable String name)
    {
        return userService.get(name);
    }

    @PostMapping("/add")
    public User add(@RequestBody User u)
    {
        return userService.add(u);
    }
    
}
