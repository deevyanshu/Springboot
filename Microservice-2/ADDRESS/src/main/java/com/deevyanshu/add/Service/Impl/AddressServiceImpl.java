package com.deevyanshu.add.Service.Impl;

import com.deevyanshu.add.Exception.ResourceNotFoundException;
import com.deevyanshu.add.Repository.AddressRepository;
import com.deevyanshu.add.Service.AddressService;
import com.deevyanshu.add.model.Dto.AddressDto;
import com.deevyanshu.add.model.Dto.AddressRequest;
import com.deevyanshu.add.model.Dto.AddressRequestDto;
import com.deevyanshu.add.model.Entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AddressDto> saveAddress(AddressRequest addressRequest) {
        //TODO: check if employee exists or not
        List<Address> savedAddresses=addressRepository.saveAll(this.saveOrUpdateAddressRequest(addressRequest));
        return savedAddresses.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public List<AddressDto> updateAddress(AddressRequest addressRequest) {
        //TODO: check if employee exists or not

        List<Address> addressByEmpId=addressRepository.findAllByEmpId(addressRequest.getEmpId());

        if(addressByEmpId.isEmpty())
        {
            throw new RuntimeException("No address found for employee with id: "+addressRequest.getEmpId());
        }

        List<Address> listToUpdate=this.saveOrUpdateAddressRequest(addressRequest);

        List<Long> upcomingNonNullIds=listToUpdate.stream().map(Address::getId).filter(Objects::nonNull).toList();

        List<Long> existingIds=addressByEmpId.stream().map(Address::getId).toList();

        List<Long> idsToDelete=existingIds.stream().filter(id -> !upcomingNonNullIds.contains(id)).toList();

        if(!idsToDelete.isEmpty())
        {
            addressRepository.deleteAllById(idsToDelete);
        }

        List<Address> updatedAddress=addressRepository.saveAll(listToUpdate);

        return updatedAddress.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public AddressDto getSingleAddress(Long id) {
        Address address=addressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList=addressRepository.findAll();
        if(addressList.isEmpty())
        {
            throw new ResourceNotFoundException("No address found");
        }
        return addressList.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public void deleteAddress(Long id) {
        Address address=addressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
        addressRepository.delete(address);
    }

    private List<Address> saveOrUpdateAddressRequest(AddressRequest addressRequest)
    {
        List<Address> listToSave=new ArrayList<>();
        for(AddressRequestDto addressRequestDto : addressRequest.getAddressRequestDtoList())
        {
            Address address=new Address();
            address.setId(addressRequestDto.getId()!=null ? addressRequestDto.getId() : null);
            address.setStreet(addressRequestDto.getStreet());
            address.setPinCode(addressRequestDto.getPinCode());
            address.setCity(addressRequestDto.getCity());
            address.setCountry(addressRequestDto.getCountry());
            address.setAddressType(addressRequestDto.getAddressType());
            address.setEmpId(addressRequest.getEmpId());
            listToSave.add(address);
        }
        return listToSave;
    }
}
