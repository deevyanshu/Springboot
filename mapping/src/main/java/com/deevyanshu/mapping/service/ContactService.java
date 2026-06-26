package com.deevyanshu.mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.mapping.entity.Contact;
import com.deevyanshu.mapping.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserService userService;

    public Contact add(Contact con,int u_id)
    {
        con.setUser(userService.get(u_id));
        return contactRepository.save(con);
    }
    
}
