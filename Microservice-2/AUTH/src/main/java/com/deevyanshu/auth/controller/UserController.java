package com.deevyanshu.auth.controller;

import com.deevyanshu.auth.model.dto.JwtResponse;
import com.deevyanshu.auth.model.dto.LoginRequest;
import com.deevyanshu.auth.model.dto.UserDto;
import com.deevyanshu.auth.model.entity.User;
import com.deevyanshu.auth.service.UserService;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody User user) {
        UserDto response = userService.saveUser(user);
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.CREATED);
    }

    @PostMapping("/generate-token")
    public JwtResponse generateToken(@RequestBody LoginRequest request) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if(authentication.isAuthenticated())
        {
            return userService.generateToken(request.getUsername());
        }
        else
        {
            throw new RuntimeException("Invalid access");
        }
    }
}
