package com.deevyanshu.ratingservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.ratingservice.model.Rating;
import com.deevyanshu.ratingservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating create(Rating r) {
       String s=UUID.randomUUID().toString();
       r.setRatingId(s);
        return ratingRepository.save(r);
    }

    @Override
    public List<Rating> getall() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userid) {
        return ratingRepository.findByUserId(userid);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelid) {
        return ratingRepository.findByHotelId(hotelid);
    }
    
}
