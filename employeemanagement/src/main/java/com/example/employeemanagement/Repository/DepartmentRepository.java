package com.example.employeemanagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    Optional<Department> findByDepartment(String department);
}
