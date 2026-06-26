package com.deevyanshu.mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.mapping.entity.Contact;
import com.deevyanshu.mapping.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/add")
    public Contact add(@RequestBody Contact con,@RequestParam int id)
    {
        return contactService.add(con, id);
    }
    
}
