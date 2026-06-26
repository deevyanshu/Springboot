package com.deevyanshu.bookingsystem.Controller;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.bookingsystem.Entity.BusDetails;
import com.deevyanshu.bookingsystem.Exception.SeatNotAvailable;
import com.deevyanshu.bookingsystem.Repository.BusRepository;
import com.deevyanshu.bookingsystem.Service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BusRepository busRepository;

    @GetMapping("/book")
    public void bookTicket()
    {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    bookingService.bookTicket();
                } catch (SeatNotAvailable | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        });
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    bookingService.bookTicket1();
                } catch (SeatNotAvailable | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        });
    }

    @PostMapping("/addbus")
    public void addBus(@RequestParam String number, @RequestParam int capacity)
    {
        BusDetails busDetails=new BusDetails();
        busDetails.setSeatCapacity(capacity);
        busDetails.setNumber(number);
        busDetails.setDeparDateTime(LocalDateTime.now());
        busRepository.save(busDetails);

    }

    
    
}
