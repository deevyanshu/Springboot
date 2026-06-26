package com.example.angularcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angularcrud.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}
