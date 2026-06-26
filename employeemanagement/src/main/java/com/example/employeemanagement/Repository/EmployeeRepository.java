package com.example.employeemanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.Entity.City;
import com.example.employeemanagement.Entity.Department;
import com.example.employeemanagement.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    List<Employee> findByCity(City city);
    List<Employee> findByDepartment(Department department);
}
