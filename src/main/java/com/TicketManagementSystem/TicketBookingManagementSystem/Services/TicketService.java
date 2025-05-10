package com.TicketManagementSystem.TicketBookingManagementSystem.Services;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Bus;
import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Seat;
import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Ticket;
import com.TicketManagementSystem.TicketBookingManagementSystem.Repositories.BusRepository;
import com.TicketManagementSystem.TicketBookingManagementSystem.Repositories.SeatRepository;
import com.TicketManagementSystem.TicketBookingManagementSystem.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TicketService {
    @Autowired
    private SeatService seatService;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BusRepository busRepository;
    public Ticket addTicket(int busId, int seatId, String passengerName) {
        Optional<Seat> seatOpt = seatRepository.findById(seatId);
        Optional<Bus> busOpt = busRepository.findById(busId);

        if (seatOpt.isPresent() && busOpt.isPresent()) {
            Ticket ticket = new Ticket();
            ticket.setPassenger_Name(passengerName);
            ticket.setSeat(seatOpt.get());
            ticket.setBus(busOpt.get());
            seatService.updateSeatStatus(seatId, "Booked");
            return ticketRepository.save(ticket);
        } else {
            throw new RuntimeException("Bus or Seat not found");
        }
    }
    public Optional<Ticket> getTicketById(int id)
    {
        return ticketRepository.findById(id);
    }
    public void deleteTicketById(int id)
    {
        Optional<Ticket> t=ticketRepository.findById(id);
        int seatId;
        if(t.isPresent())
        {
            Ticket ticket=t.get();
            seatId=ticket.getSeatId();
            seatService.updateSeatStatus(seatId, "Available");
        }
        ticketRepository.deleteById(id);
    }
}
