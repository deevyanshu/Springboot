package com.deevyanshu.add.Service;

import com.deevyanshu.add.model.Dto.AddressDto;
import com.deevyanshu.add.model.Dto.AddressRequest;

import java.util.List;

public interface AddressService {
    List<AddressDto> saveAddress(AddressRequest addressRequest);

    List<AddressDto> updateAddress(AddressRequest addressRequest);

    AddressDto getSingleAddress(Long id);

    List<AddressDto> getAllAddress();

    void deleteAddress(Long id);
}
