package com.deevyanshu.add.controller;

import com.deevyanshu.add.Service.AddressService;
import com.deevyanshu.add.model.Dto.AddressDto;
import com.deevyanshu.add.model.Dto.AddressRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public ResponseEntity<List<AddressDto>> saveAddress(@RequestBody AddressRequest addressRequest) {
        List<AddressDto> savedAddresses = addressService.saveAddress(addressRequest);
        return new ResponseEntity<>(savedAddresses, HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<List<AddressDto>> updateAddress(@PathVariable Long empId, @RequestBody AddressRequest addressRequest) {

        List<AddressDto> updatedAddresses = addressService.updateAddress(addressRequest);
        return new ResponseEntity<>(updatedAddresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getSingleAddress(@PathVariable Long id) {
        AddressDto addressDto = addressService.getSingleAddress(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        List<AddressDto> addressDtos = addressService.getAllAddress();
        return new ResponseEntity<>(addressDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
