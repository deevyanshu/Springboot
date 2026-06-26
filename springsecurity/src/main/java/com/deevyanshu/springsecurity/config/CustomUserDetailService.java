package com.deevyanshu.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.deevyanshu.springsecurity.model.User;
import com.deevyanshu.springsecurity.service.UserService;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userservice;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user=userservice.get(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("not found");
        }
        return new CustomUserDetails(user);
    }
    
}
