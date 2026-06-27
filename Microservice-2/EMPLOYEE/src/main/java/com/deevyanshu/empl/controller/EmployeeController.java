package com.deevyanshu.empl.controller;

import com.deevyanshu.empl.Exception.MissingParameterException;
import com.deevyanshu.empl.model.dto.EmployeeDto;
import com.deevyanshu.empl.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto response=employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto response=employeeService.updateEmployee(id,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getSingleEmployee(@PathVariable Long id)
    {
        EmployeeDto response=employeeService.getSingleEmployee(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> response=employeeService.getAllEmployees();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get-by-emp-code-and-company-name")
    public ResponseEntity<EmployeeDto> getEmployeeByEmpCodeAndCompanyName(@RequestParam(required = false) String empCode, @RequestParam(required = false) String companyName) {
        List<String> missingParams = new ArrayList<>();
        if(empCode == null || empCode.trim().isEmpty()) {
            missingParams.add("empCode");
        }

        if(companyName == null || companyName.trim().isEmpty()) {
            missingParams.add("companyName");
        }

        if(!missingParams.isEmpty()){
            String finalMessage=missingParams.stream().collect(Collectors.joining(","));
            throw new MissingParameterException("Missing required parameter(s): " + finalMessage);
        }

        EmployeeDto employeeDto=employeeService.getEmployeeByEmpCodeAndEmpName(empCode, companyName);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

}
