package com.deevyanshu.empl.Client;

import com.deevyanshu.empl.model.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//this is without url because we are using eureka server for service discovery and also using load balancer so
// we don't need to specify the url of the service we are calling because eureka server will take care of it
// and also load balancer will take care of it
@FeignClient(name = "ADDRESS")
public interface AddressClient {
    @GetMapping("/addresses/emp/{empId}")
    List<AddressDto> getAddressByEmpId(@PathVariable Long empId);
}
