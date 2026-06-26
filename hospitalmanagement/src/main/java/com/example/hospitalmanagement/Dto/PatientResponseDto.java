package com.example.hospitalmanagement.Dto;

import java.time.LocalDate;

import com.example.hospitalmanagement.Entity.BloodGroup;

import lombok.Data;

@Data
public class PatientResponseDto {
     private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroup bloodGroup;
}
