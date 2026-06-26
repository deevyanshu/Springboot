package com.deevyanshu.angularlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.angularlogin.model.Authentication;
import com.deevyanshu.angularlogin.model.User;
import com.deevyanshu.angularlogin.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(@RequestBody User user)
    {
        return userService.add(user);
    }

    @GetMapping("/auth")
    public Authentication auth()
    {
        return new Authentication("Authenticated");
    }
    
}
