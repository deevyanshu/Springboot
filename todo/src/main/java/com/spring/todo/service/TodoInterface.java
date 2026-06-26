package com.spring.todo.service;

import java.util.List;

import com.spring.todo.model.ToDo;

public interface TodoInterface {

    public ToDo add(ToDo t);

    public List<ToDo> getall();

    public ToDo getitem(int id);
    
}
