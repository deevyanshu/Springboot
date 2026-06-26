package com.scm.scm2.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.scm.scm2.entity.User;
import com.scm.scm2.service.UserService;


public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userService.getUserByEmail(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("not found");
        }

        return new CustomUserDetails(user);
    }
    
}
