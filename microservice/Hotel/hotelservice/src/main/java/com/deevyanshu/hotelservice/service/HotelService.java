package com.deevyanshu.hotelservice.service;

import java.util.List;

import com.deevyanshu.hotelservice.model.Hotel;

public interface HotelService {
    
    public Hotel create(Hotel hotel);

    public Hotel get(String id);

    public List<Hotel> getall();
}
