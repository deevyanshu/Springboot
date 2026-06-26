package com.deevyanshu.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.hotelservice.model.Hotel;
import com.deevyanshu.hotelservice.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelServiceImpl;

    @PostMapping("/add")
    public Hotel create(@RequestBody Hotel hotel)
    {
        return hotelServiceImpl.create(hotel);
    }

    @GetMapping("/get/{id}")
    public Hotel get(@PathVariable String id)
    {
        return hotelServiceImpl.get(id);
    }

    @GetMapping("/getall")
    public List<Hotel> getAll()
    {
        return hotelServiceImpl.getall();
    }
    
}
