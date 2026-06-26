package com.deevyanshu.bookingsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.bookingsystem.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
    
}
