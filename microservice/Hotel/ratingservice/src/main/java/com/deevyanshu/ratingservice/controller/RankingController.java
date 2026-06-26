package com.deevyanshu.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.ratingservice.model.Rating;
import com.deevyanshu.ratingservice.service.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RankingController {

    @Autowired
    RatingServiceImpl ratingServiceImpl;

    @PostMapping("/add")
    public Rating create(@RequestBody Rating rating)
    {
        return ratingServiceImpl.create(rating);
    }

    @GetMapping("/getall")
    public List<Rating> getRatings()
    {
        return ratingServiceImpl.getall();
    }

    @GetMapping("/get/user/{userid}")
    public List<Rating> getRatingByUserId(@PathVariable String userid)
    {
        return ratingServiceImpl.getRatingByUserId(userid);
    }

    @GetMapping("/get/hotel/{hotel}")
    public List<Rating> getRatingByHotelId(@PathVariable String hotel)
    {
        return ratingServiceImpl.getRatingByHotelId(hotel);
    }
    
}
