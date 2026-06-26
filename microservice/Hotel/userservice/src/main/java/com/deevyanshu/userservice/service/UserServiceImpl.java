package com.deevyanshu.userservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deevyanshu.userservice.model.Hotel;
import com.deevyanshu.userservice.model.Rating;
import com.deevyanshu.userservice.model.User;
import com.deevyanshu.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
      String s= UUID.randomUUID().toString();
      user.setId(s);  
      return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
      List<User> list=userRepository.findAll();
      for(User u:list)
      {
        Rating[] ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/get/user/"+u.getId(), Rating[].class);
        for(Rating r: ratings)
        {
          r.setHotel(restTemplate.getForObject("http://HOTEL-SERVICE/hotels/get/"+r.getHotelId(), Hotel.class));
        }
        u.setRatings(Arrays.stream(ratings).toList());
      }      
        return list;
    }

    
    @Override
    public User getUser(String id) {
      User user=userRepository.findById(id).get();
      Rating[] ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/get/user/id", Rating[].class);
      for(Rating r: ratings)
      {
        r.setHotel(restTemplate.getForObject("http://HOTEL-SERVICE/hotels/get/"+r.getHotelId(), Hotel.class));
      }
      user.setRatings(Arrays.stream(ratings).toList());
      return user;
    }
    
}
