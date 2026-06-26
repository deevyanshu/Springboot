package com.deevyanshu.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deevyanshu.springsecurity.model.User;

@Service
public class UserService {

    List<User> list=new ArrayList<>();

    @Autowired
    public PasswordEncoder encoder;
    
    
    public UserService()
    {
        
    }
    

    public List<User> getall()
    {
        return list;
    }

    public User get(String name)
    {
        for(User u:list)
        {
            if(u.getUsername().equals(name))
            {
                return u;
            }
        }
        return null;
    }

    public User add(User u)
    {
        u.setPassword(encoder.encode(u.getPassword()));
        list.add(u);
        return u;
    }
}
