package com.TicketManagementSystem.TicketBookingManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bus_id;
    private String bus_travels;
    private String source;
    private String destination;
    private LocalDateTime departure_time;
    private LocalDateTime reaching_time;
    @OneToMany(mappedBy = "bus" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;
}
