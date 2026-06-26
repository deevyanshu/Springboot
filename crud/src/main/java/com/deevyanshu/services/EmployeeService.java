package com.deevyanshu.services;

import java.util.List;

import com.deevyanshu.Model.Employee;

public interface EmployeeService {

    public Employee add(Employee e);

    public List<Employee> getAll();

    public Employee getById(long id);

    public Employee delete(long id);

    public Employee update(long id, Employee e);
    
}
