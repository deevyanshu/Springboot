package com.deevyanshu.contacts.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.deevyanshu.contacts.model.Contacts;

@Service
public class ContactService {

    private List<Contacts> list=new ArrayList<>();
    int j=0;

    public Contacts add(Contacts c)
    {
        c.setId(++j);
        list.add(c);
        return c;
    }

    public List<Contacts> getall()
    {
        return list;
    }

    public List<Contacts> getByUserId(int userid)
    {
        List<Contacts> con= new ArrayList<>();
        for(Contacts c:list)
        {
            if(c.getUserid()==userid)
            {
                con.add(c);
            }
        }
        return con;
    }
    
}
