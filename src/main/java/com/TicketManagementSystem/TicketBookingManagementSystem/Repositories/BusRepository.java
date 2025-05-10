package com.TicketManagementSystem.TicketBookingManagementSystem.Repositories;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Integer> {
}
