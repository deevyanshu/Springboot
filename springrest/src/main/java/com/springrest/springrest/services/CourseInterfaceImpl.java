package com.springrest.springrest.services;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.springrest.springrest.model.Courses;

@Service
public class CourseInterfaceImpl implements CourseInterface {

    ArrayList<Courses> list=new ArrayList<>();  

    @Override
    public ArrayList<Courses> getAll() { 
        return list;
    }

    @Override
    public Courses add(Courses c) {
        
        list.add(c);
        return c;
    }

    @Override
    public Courses delete(int id) {
        
        for(Courses i:list)
        {
            if(i.getId()==id)
            {
                list.remove(i);
                return i;
            }
        }
        return null;
    }

    @Override
    public Courses update(int id, Courses c) {
        for(Courses i:list)
        {
            if(i.getId()==id)
            {
                i.setAuthor(c.getAuthor());
                i.setName(c.getName());
                return c;
            }
        }
        return null;
        
    }
    
}
