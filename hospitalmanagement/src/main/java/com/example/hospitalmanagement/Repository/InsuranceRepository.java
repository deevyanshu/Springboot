package com.example.hospitalmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.Entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long>{
    
}
