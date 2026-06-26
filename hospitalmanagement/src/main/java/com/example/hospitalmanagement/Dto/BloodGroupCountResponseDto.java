package com.example.hospitalmanagement.Dto;

import com.example.hospitalmanagement.Entity.BloodGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseDto {
    private BloodGroup bloodGroupType;
    private Long count;
}
