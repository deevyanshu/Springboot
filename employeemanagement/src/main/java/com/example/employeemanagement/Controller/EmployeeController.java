package com.example.employeemanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.Service.EmployeeService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp)
    {
        log.info("Creating employee: {}",emp);
        return new ResponseEntity<>(employeeService.add(emp),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee emp,@PathVariable Long id)
    {
        log.info("Updating employee: {}", emp);
        return new ResponseEntity<>(employeeService.update(id, emp),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id)
    {
        log.info("Deleting employee");
        return new ResponseEntity<>(employeeService.delete(id),HttpStatus.OK);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<List<Employee>> getAllEmployeesByCity(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.employeesByCity(id),HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> getAllEmployeesByDepartment(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.employeesByDepartment(id),HttpStatus.OK);
    } 



    
}
