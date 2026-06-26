package com.example.hospitalmanagement.Dto;

import java.util.HashSet;
import java.util.Set;

import com.example.hospitalmanagement.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

    private String username;
    private String password;
    private String name;
    private Set<Role> roles=new HashSet<>();
    
}
