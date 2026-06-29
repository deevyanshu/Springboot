package com.deevyanshu.add.client;

import com.deevyanshu.add.model.Dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="employeeClient",url = "${employee.service.url}")
public interface EmployeeClient {

    @GetMapping("/{id}")
    EmployeeDto getSingleEmployee(@PathVariable Long id);
}
