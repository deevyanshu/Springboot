package com.deevyanshu.contact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deevyanshu.contact.model.Contacts;
import com.deevyanshu.contact.model.User;

@Service
public class ContactsServiceImpl implements ContactsService {

    List<User> list=new ArrayList<>();

    @Override
    public List<User> getAll() {
        
        return list;
    }

    @Override
    public User get(int id) {
        for(User i:list)
        {
            if(i.getId()==id)
            {
                return i;
            }
        }
        return null;
    }

    @Override
    public User add(User user) {
        list.add(user);
        return user;
    }
    
}
