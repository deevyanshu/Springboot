package com.example.hospitalmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.Entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
    
}
