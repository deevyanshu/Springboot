package com.deevyanshu.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.jpa.entity.User;
import com.deevyanshu.jpa.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/add")
    public User add(@RequestBody User user)
    {
        return userServiceImpl.add(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id)
    {
        return userServiceImpl.get(id);
    }
    
    @PutMapping("/update/{id}")
    public User update(@PathVariable int id,@RequestBody User user)
    {
        return userServiceImpl.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable int id)
    {
        return userServiceImpl.delete(id);
    }

    @GetMapping("/get/{name}")
    public User getByName(@PathVariable String name)
    {
        return userServiceImpl.getByName(name);
    }
}
