package com.TicketManagementSystem.TicketBookingManagementSystem.Repositories;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
