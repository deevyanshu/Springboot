package com.deevyanshu.empl.service.impl;

import com.deevyanshu.empl.Exception.BadRequestException;
import com.deevyanshu.empl.Exception.ResourceNotFoundException;
import com.deevyanshu.empl.model.dto.EmployeeDto;
import com.deevyanshu.empl.model.entity.Employee;
import com.deevyanshu.empl.repository.EmployeeRepository;
import com.deevyanshu.empl.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        if(employeeDto.getId()!=null)
        {
            throw new RuntimeException("Employee already exists");
        }

        Employee entity=modelMapper.map(employeeDto, Employee.class);

        Employee savedEntity=employeeRepository.save(entity);
        return modelMapper.map(savedEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        if(id==null || employeeDto.getId()==null)
        {
            throw new BadRequestException("please provide employee id");
        }

        if(!Objects.equals(id,employeeDto.getId()))
        {
            throw new BadRequestException("id mismatched");
        }
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
        Employee entity=modelMapper.map(employeeDto,Employee.class);
        Employee updatedEntity=employeeRepository.save(entity);
        return modelMapper.map(updatedEntity, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto getSingleEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));


        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> all=employeeRepository.findAll();
        if(all.isEmpty())
        {
            throw new ResourceNotFoundException("no employees found");
        }
        List<EmployeeDto> employees=all.stream().map(emp -> modelMapper.map(emp, EmployeeDto.class)).toList();
        return employees;
    }

    @Override
    public EmployeeDto getEmployeeByEmpCodeAndEmpName(String empCode, String companyName) {
        Employee emp=employeeRepository.findByEmpCodeAndCompanyName(empCode, companyName).orElseThrow(()->new ResourceNotFoundException("not found"));
        return modelMapper.map(emp, EmployeeDto.class);
    }
}
