package com.deevyanshu.empl.repository;

import com.deevyanshu.empl.model.dto.EmployeeDto;
import com.deevyanshu.empl.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmpCodeAndCompanyName(String empCode, String companyName);
}
