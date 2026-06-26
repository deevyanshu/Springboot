package com.springrest.springrest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.model.Courses;
import com.springrest.springrest.services.CourseInterfaceImpl;

@RestController
@RequestMapping("/Courses")
public class CoursesController {

    @Autowired
    CourseInterfaceImpl courseInterfaceImpl;

    @GetMapping(value = "/getall")
    public ArrayList<Courses> getAll()
    {
        return courseInterfaceImpl.getAll();
    }


    @PostMapping(value = "/addcourse")
    public Courses add(@RequestBody Courses c)
    {
        return courseInterfaceImpl.add(c);
    }

    @DeleteMapping(value = "/{id}")
    public Courses delete(@PathVariable int id)
    {
        return courseInterfaceImpl.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    public Courses update(@PathVariable int id, @RequestBody Courses c)
    {
        return courseInterfaceImpl.update(id, c);
    }
    
}
