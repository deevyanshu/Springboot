package com.example.employeemanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.Entity.City;
import com.example.employeemanagement.Entity.Department;
import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.GlobalException.CityNotFoundException;
import com.example.employeemanagement.GlobalException.DepartmentNotFoundException;
import com.example.employeemanagement.GlobalException.EmployeeNotFoundException;
import com.example.employeemanagement.Repository.CityRepository;
import com.example.employeemanagement.Repository.DepartmentRepository;
import com.example.employeemanagement.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee add(Employee emp)
    {
        if(emp.getCity().getCity().isEmpty()) throw new CityNotFoundException("City is required");
        if(emp.getDepartment().getDepartment().isEmpty()) throw new DepartmentNotFoundException("Department is required");
        City city=cityRepository.findByCity(emp.getCity().getCity()).orElseGet(()->cityRepository.save(emp.getCity()));
        Department dept=departmentRepository.findByDepartment(emp.getDepartment().getDepartment()).orElseGet(()->departmentRepository.save(emp.getDepartment()));
        
            emp.setCity(city);   
        

            emp.setDepartment(dept);


        return employeeRepository.save(emp);

        

    }

    public Employee delete(Long id)
    {
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
        
        employeeRepository.delete(emp);
        return emp;
    }

    public Employee getById(Long id)
    {
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
        return emp;
    }

    public Employee update(Long id,Employee empl)
    {
        if(empl.getCity().getCity().isEmpty()) throw new CityNotFoundException("City is required");
        if(empl.getDepartment().getDepartment().isEmpty()) throw new DepartmentNotFoundException("Department is required");
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
        City city=cityRepository.findByCity(empl.getCity().getCity()).orElseGet(()->cityRepository.save(empl.getCity()));
        emp.setCity(city);
        
        Department dept=departmentRepository.findByDepartment(empl.getDepartment().getDepartment()).orElseGet(()->departmentRepository.save(empl.getDepartment()));

        emp.setDepartment(dept);
        emp.setAddress(empl.getAddress());
        
        emp.setDateOfJoining(empl.getDateOfJoining());
        emp.setEmail(empl.getEmail());
        emp.setFirstName(empl.getFirstName());
        emp.setJobTitle(empl.getJobTitle());
        emp.setLastName(empl.getLastName());
        emp.setMobile(empl.getMobile());
        emp.setSalary(empl.getSalary());
        employeeRepository.save(emp);
        return emp;
    }

    public List<Employee> getAllEmployees()
    {
        if(employeeRepository.findAll().isEmpty() || employeeRepository.findAll()==null) throw new EmployeeNotFoundException("No record");
        return employeeRepository.findAll();
    }
    
    public List<Employee> employeesByCity(Long id)
    {
        City city= cityRepository.findById(id).orElseThrow(()-> new CityNotFoundException("City Not Found"));
        return employeeRepository.findByCity(city);
    }

    public List<Employee> employeesByDepartment(Long id)
    {
        Department dept=departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department Not Found"));
        return employeeRepository.findByDepartment(dept);
    }
}
