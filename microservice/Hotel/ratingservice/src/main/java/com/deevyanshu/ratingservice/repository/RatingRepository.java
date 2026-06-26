package com.deevyanshu.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.ratingservice.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String>{
       
    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String hotelid);
}
