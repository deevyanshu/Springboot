package com.deevyanshu.bookingsystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.deevyanshu.bookingsystem.Entity.BusDetails;

import jakarta.persistence.LockModeType;

@Repository
public interface BusRepository extends JpaRepository<BusDetails,Integer>{
    
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<BusDetails> findWithLockingById(int id);
}
