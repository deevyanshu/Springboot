package com.deevyanshu.empl.service;

import com.deevyanshu.empl.model.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    EmployeeDto getSingleEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeByEmpCodeAndEmpName(String empCode, String companyName);
}
