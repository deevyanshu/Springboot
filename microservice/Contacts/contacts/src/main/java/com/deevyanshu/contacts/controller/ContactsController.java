package com.deevyanshu.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.contacts.model.Contacts;
import com.deevyanshu.contacts.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public Contacts add(@RequestBody Contacts c)
    {
        return contactService.add(c);
    }

    @GetMapping("/getall")
    public List<Contacts> getall()
    {
        return contactService.getall();
    }

    @GetMapping("/get/{userid}")
    public List<Contacts> getByUserId(@PathVariable int userid)
    {
        return contactService.getByUserId(userid);
    }
    
}
