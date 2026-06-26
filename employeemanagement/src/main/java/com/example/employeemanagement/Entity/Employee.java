package com.example.employeemanagement.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Job title is required")
    private String jobTitle;
    @NotNull(message = "Salary is required")
    private double salary;
    @Column(unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
    private String mobile;
    @Column(unique = true)
    @Email(message = "Invalid email address")
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private Date dateOfJoining;
    
}
