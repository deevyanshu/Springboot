package com.example.angularcrud.Service;

import java.util.List;

import com.example.angularcrud.Entity.Employee;

public interface EmployeeService {

    public Employee addEmployee(Employee e);

    public Employee updateEmployee(int id,Employee e);

    public Employee deleteEmployee(int id);

    public List<Employee> allEmployees();

    public Employee getEmployeeById(int id);
}
