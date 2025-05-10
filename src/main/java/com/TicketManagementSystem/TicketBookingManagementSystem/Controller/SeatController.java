package com.TicketManagementSystem.TicketBookingManagementSystem.Controller;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Seat;
import com.TicketManagementSystem.TicketBookingManagementSystem.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        Optional<Seat> seat = seatService.getSeatById(id);
        return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Seat addSeat(@RequestBody Seat seat) {
        return seatService.addSeat(seat);
    }

    @PutMapping("/{seatId}/status")
    public Seat updateSeatStatus(@PathVariable int seatId, @RequestParam String newStatus) {
        return seatService.updateSeatStatus(seatId, newStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable int id) {
        Optional<Seat> seat = seatService.getSeatById(id);
        if (seat.isPresent()) {
            seatService.deleteSeat(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public void deleteAllSeats() {
        seatService.deleteAllSeats();
    }
}
