package com.deevyanshu.hotelservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.hotelservice.model.Hotel;
import com.deevyanshu.hotelservice.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String s=UUID.randomUUID().toString();
        hotel.setId(s);
       return hotelRepository.save(hotel);
    }

    @Override
    public Hotel get(String id) {
       return hotelRepository.findById(id).get();
    }

    @Override
    public List<Hotel> getall() {
       return hotelRepository.findAll();
    }
    
}
