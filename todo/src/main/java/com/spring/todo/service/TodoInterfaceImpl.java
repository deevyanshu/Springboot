package com.spring.todo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.todo.model.ToDo;

@Service
public class TodoInterfaceImpl implements TodoInterface{

    List<ToDo> list=new ArrayList<>();
    

    @Override
    public ToDo add(ToDo t) {
        if(list.size()==0)
        {
            t.setId(1);
        }else
        {
            t.setId(list.size()+1);
        }
        list.add(t);
        return t;   
    }

    @Override
    public List<ToDo> getall() {
        Collections.sort(list,new Comparator<ToDo>() {

            @Override
            public int compare(ToDo o1, ToDo o2) {
                
                return o2.getPriority()-o1.getPriority();
            }
            
        });
        return list;
    }

    @Override
    public ToDo getitem(int id) {
        for(ToDo t:list)
        {
            if(t.getId()==id)
            {
                return t;
            }
        }
        return null;
    }
    
}
