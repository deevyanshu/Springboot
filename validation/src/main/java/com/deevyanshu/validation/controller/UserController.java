package com.deevyanshu.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.validation.entitity.User;
import com.deevyanshu.validation.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/validation")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User get(@Valid @PathVariable int id)
    {
        return userService.get(id);
    }

    @PostMapping("/add")
    public User add(@Valid @RequestBody User u)
    {
        return userService.add(u);
    }
    
}
