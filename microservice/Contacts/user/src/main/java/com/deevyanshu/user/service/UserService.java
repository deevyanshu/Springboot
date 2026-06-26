package com.deevyanshu.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deevyanshu.user.configexception.NullException;
import com.deevyanshu.user.model.Contacts;
import com.deevyanshu.user.model.User;

@Service
public class UserService {
    
    private List<User> list=new ArrayList<>();
    int i=0;

    @Autowired
    private RestTemplate restTemplate;

    public User add(User u) throws Exception
    {
        User user=u;
        if(user.getName()==null)
        {
            throw new NullException("name cannot be null");
        }else
        {
            u.setId(++i);
            list.add(u);
            return u;
        }
        
    }

    public User get(int id)
    {
        for(User u:list)
        {
            if(u.getId()==id)
            {
                List<Contacts> con=restTemplate.getForObject("http://CONTACTS/contacts/get/"+id, ArrayList.class);
                u.setContacts(con);
                return u;
            }
        }
        return null;
    }

    public List<User> getall()
    {
        return list;
    }


}
