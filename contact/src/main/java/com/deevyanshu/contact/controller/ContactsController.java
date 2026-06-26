package com.deevyanshu.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.contact.model.User;
import com.deevyanshu.contact.service.ContactsServiceImpl;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    ContactsServiceImpl contactsServiceImpl;

    @GetMapping("/all")
    public List<User> getAll()
    {
        return contactsServiceImpl.getAll();
    }

    @PostMapping("/add")
    public User add(@RequestBody User user)
    {
        return contactsServiceImpl.add(user);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable int id)
    {
        return contactsServiceImpl.get(id);
    }
    
}
