package com.deevyanshu.auth.service;

import com.deevyanshu.auth.model.dto.JwtResponse;
import com.deevyanshu.auth.model.dto.UserDto;
import com.deevyanshu.auth.model.entity.User;
import com.deevyanshu.auth.repository.UserRepository;
import com.deevyanshu.auth.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public UserDto saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser=userRepository.save(user);
        return new UserDto(savedUser.getId(),savedUser.getEmail(),savedUser.getUsername(),savedUser.getRoles());
    }

    public JwtResponse generateToken(String username){
        String token=jwtUtil.generateToken(username);
        return new JwtResponse(token,"Bearer", jwtUtil.extractExpiration(token).toString());
    }
}
