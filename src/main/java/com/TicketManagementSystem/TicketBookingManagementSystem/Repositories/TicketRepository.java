package com.TicketManagementSystem.TicketBookingManagementSystem.Repositories;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
