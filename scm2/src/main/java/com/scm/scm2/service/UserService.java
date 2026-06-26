package com.scm.scm2.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.scm2.entity.User;
import com.scm.scm2.helper.ResourceNotFoundException;
import com.scm.scm2.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user)
    {
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(List.of("ROLE_USER"));
        return userRepository.save(user);
    }

    public User getUserById(String id)
    {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user) 
    {
        User u=userRepository.findById(user.getUserId()).get();
        if(u==null)
        {
            throw new ResourceNotFoundException("User not found");
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAbout(user.getAbout());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setProfilePic(user.getProfilePic());
        u.setEnabled(user.isEnabled());
        u.setEmailVerified(user.isEmailVerified());
        u.setPhoneVerified(user.isPhoneVerified());
        u.setProvider(user.getProvider());
        u.setProviderId(user.getProviderId());
        return userRepository.save(u);
    }

    public void deleteUser(String id)
    {
        User u=userRepository.findById(id).get();
        userRepository.delete(u);
    }

    public boolean isUserExist(String id)
    {
        User u=userRepository.findById(id).orElse(null);
        return u != null ? true:false;
    }

    public boolean isUserExistByEmail(String email)
    {
        User u=userRepository.findByEmail(email).orElse(null);
        return u!=null?true:false;
    }

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email).get();
    }
    
}
