package com.example.hospitalmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
}
