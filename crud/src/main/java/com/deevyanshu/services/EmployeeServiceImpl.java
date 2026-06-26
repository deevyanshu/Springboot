package com.deevyanshu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.Model.Employee;
import com.deevyanshu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee add(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee delete(long id) {
        Employee e=employeeRepository.findById(id).get();
        employeeRepository.delete(e);
        return e;
    }

    @Override
    public Employee update(long id,Employee e) {
        Employee emp=employeeRepository.findById(id).get();

        emp.setEmail(e.getEmail());
        emp.setFirstName(e.getFirstName());
        emp.setId(e.getId());
        emp.setLastName(e.getLastName());
        return employeeRepository.save(emp);
    }
    
}
