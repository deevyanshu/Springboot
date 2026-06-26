package com.example.employeemanagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.Entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long>{
    Optional<City> findByCity(String city);
}
