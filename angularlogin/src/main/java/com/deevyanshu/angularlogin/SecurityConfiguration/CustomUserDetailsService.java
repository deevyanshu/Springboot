package com.deevyanshu.angularlogin.SecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.deevyanshu.angularlogin.model.User;
import com.deevyanshu.angularlogin.service.UserService;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user=userService.get(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("not found");
        }
        return new CustomUserDetails(user);
    }
    
}
