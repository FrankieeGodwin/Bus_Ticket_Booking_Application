package com.TicketManagementSystem.TicketBookingManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_id;

    private String seat_number;
    private double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "Bus_id")
    @JsonIgnore
    private Bus bus;

    @Transient
    private Integer bus_id;

    @Transient
    private String bus_travels;

    public Integer getBus_id() {
        if (bus != null) {
            return bus.getBus_id();
        } else {
            return null;
        }
    }
    public String getBus_travels()
    {
        if (bus != null) {
            return bus.getBus_travels();
        } else {
            return null;
        }
    }
}
