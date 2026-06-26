package com.deevyanshu.bookingsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.bookingsystem.Entity.BusDetails;
import com.deevyanshu.bookingsystem.Entity.Ticket;
import com.deevyanshu.bookingsystem.Exception.SeatNotAvailable;
import com.deevyanshu.bookingsystem.Repository.BusRepository;
import com.deevyanshu.bookingsystem.Repository.TicketRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private TicketRepository ticketRepository;

    private void saveTicket(String name, BusDetails busDetails) throws SeatNotAvailable
    {
        if(busDetails.getSeatCapacity()<=busDetails.getTickets().size())
        {
            throw new SeatNotAvailable();
        }

        Ticket ticket=new Ticket();
        ticket.setName(name);
        ticket.setGender("male");
        busDetails.addTicket(ticket);
        ticketRepository.save(ticket);
    }

    @Transactional
    public void bookTicket() throws SeatNotAvailable, InterruptedException
    {
        BusDetails busDetails=busRepository.findWithLockingById(102).get();
        if(busDetails!=null)
        {
            saveTicket("John", busDetails);
        }

        //creating thread only for testing purpose not in real project
        Thread.sleep(1000);
    }

    @Transactional
    public void bookTicket1() throws SeatNotAvailable, InterruptedException
    {
        BusDetails busDetails=busRepository.findWithLockingById(102).get();
        if(busDetails!=null)
        {
            saveTicket("ken", busDetails);
        }

        //creating thread only for testing purpose not in real project
        Thread.sleep(1000);
    }
    
}
