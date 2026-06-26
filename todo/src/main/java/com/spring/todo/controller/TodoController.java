package com.spring.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.todo.model.ToDo;
import com.spring.todo.service.TodoInterfaceImpl;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoInterfaceImpl todoInterfaceImpl;

    @PostMapping("/add")
    public ToDo add(@RequestBody ToDo t)
    {
        return todoInterfaceImpl.add(t);
    }

    @GetMapping("/all")
    public List<ToDo> get()
    {
        return todoInterfaceImpl.getall();
    }

    //example of requestparam. can also be achieve through pathvariable
    @GetMapping("/getitem")
    public ToDo getitem(@RequestParam int id)
    {
        return todoInterfaceImpl.getitem(id);
    }
    
}
