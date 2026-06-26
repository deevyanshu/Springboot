package com.deevyanshu.bookingsystem.Entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BusDetails {

    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime deparDateTime;
    private int seatCapacity;
    private String number;

    @Version
    private long version;

    @OneToMany(mappedBy = "busDetails")
    private Set<Ticket> tickets;

    public void addTicket(Ticket ticket)
    {
        ticket.setBusDetails(this);
        getTickets().add(ticket);

    }


    
}
