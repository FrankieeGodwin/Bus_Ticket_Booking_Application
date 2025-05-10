package com.TicketManagementSystem.TicketBookingManagementSystem.Services;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Seat;
import com.TicketManagementSystem.TicketBookingManagementSystem.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    // Get all seats
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(int id) {
        return seatRepository.findById(id);
    }

    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(int id, Seat seatDetails) {
        seatDetails.setSeat_id(id);
        return seatRepository.save(seatDetails);
    }

    public void deleteSeat(int id) {
        seatRepository.deleteById(id);
    }

    public void deleteAllSeats() {
        seatRepository.deleteAll();
    }

    public Seat updateSeatStatus(int seatId, String newStatus) {
        Optional<Seat> seatOptional = seatRepository.findById(seatId);
        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            seat.setStatus(newStatus);
            return seatRepository.save(seat);
        }
        return null;
    }
}
