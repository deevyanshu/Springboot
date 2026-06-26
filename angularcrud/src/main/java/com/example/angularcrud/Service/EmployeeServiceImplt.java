package com.example.angularcrud.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angularcrud.Entity.Employee;
import com.example.angularcrud.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImplt implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    private List<Employee> employees=new ArrayList<>();

    @Override
    public Employee addEmployee(Employee e) {
        
        return repository.save(e);
    }

    @Override
    public Employee updateEmployee(int id,Employee e) {
        
        Employee emp=repository.findById(id).get();
        emp.setEmpEmail(e.getEmpEmail());
        emp.setEmpName(e.getEmpName());
        emp.setPhoneNumber(e.getPhoneNumber());
        emp.setSalary(e.getSalary());
        repository.save(emp);
        return emp;

    }

    @Override
    public Employee deleteEmployee(int id) {
        
        Employee emp=repository.findById(id).get();
        repository.delete(emp);
        return emp;
    }

    @Override
    public List<Employee> allEmployees() {
        
        employees=repository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        
        return repository.findById(id).get();
    }


    
}
