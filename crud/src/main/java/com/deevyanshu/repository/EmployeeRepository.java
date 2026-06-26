package com.deevyanshu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
