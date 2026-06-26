package com.example.angularcrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angularcrud.Entity.Employee;
import com.example.angularcrud.Service.EmployeeServiceImplt;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImplt service;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)
    {
        return new ResponseEntity<>(service.addEmployee(e),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee e)
    {
        return new ResponseEntity<>(service.updateEmployee(id, e),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> showAll()
    {
        return new ResponseEntity<>(service.allEmployees(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id)
    {
        return new ResponseEntity<>(service.getEmployeeById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id)
    {
        return new ResponseEntity<>(service.deleteEmployee(id),HttpStatus.OK);
    }
    
}
