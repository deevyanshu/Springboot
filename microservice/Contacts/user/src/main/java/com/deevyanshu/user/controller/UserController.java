package com.deevyanshu.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.user.model.User;
import com.deevyanshu.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User u) throws Exception
    {
        return new ResponseEntity<>(userService.add(u),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable int id)
    {
        return userService.get(id);
    }

    @GetMapping("/all")
    public List<User> getall()
    {
        return userService.getall();
    }
    
}
