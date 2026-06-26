package com.deevyanshu.ratingservice.service;

import java.util.List;

import com.deevyanshu.ratingservice.model.Rating;

public interface RatingService {

    public Rating create(Rating r);

    public List<Rating> getall();

    public List<Rating> getRatingByUserId(String userid);
    
    public List<Rating> getRatingByHotelId(String hotelid);
}
