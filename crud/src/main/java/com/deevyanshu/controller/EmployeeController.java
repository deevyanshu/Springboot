package com.deevyanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.Model.Employee;
import com.deevyanshu.services.EmployeeServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/all")
    public List<Employee> getAll()
    {
        return employeeServiceImpl.getAll();
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee e)
    {
        return employeeServiceImpl.add(e);
    }

    @GetMapping("/get/{id}")
    public Employee find(@PathVariable long id)
    {
        return employeeServiceImpl.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Employee delete(@PathVariable long id)
    {
        return employeeServiceImpl.delete(id);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable long id,@RequestBody Employee e)
    {
        return employeeServiceImpl.update(id, e);
    }
    
}
