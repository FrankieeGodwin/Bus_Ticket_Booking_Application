package com.TicketManagementSystem.TicketBookingManagementSystem.Controller;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Ticket;
import com.TicketManagementSystem.TicketBookingManagementSystem.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketServices;
    @PostMapping("/{busId}/{seatId}")
    public ResponseEntity<Ticket> bookTicket(
            @PathVariable int busId,
            @PathVariable int seatId,
            @RequestParam String passengerName) {
        Ticket ticket = ticketServices.addTicket(busId, seatId, passengerName);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<Ticket> getTicketById(@PathVariable int id)
    {
        return ticketServices.getTicketById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable int id)
    {
        ticketServices.deleteTicketById(id);
    }
}
