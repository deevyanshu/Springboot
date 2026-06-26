package com.example.hospitalmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.Entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{
    
}
