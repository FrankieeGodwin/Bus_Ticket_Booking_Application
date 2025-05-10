package com.TicketManagementSystem.TicketBookingManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;
@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Ticket_id;

    @JsonProperty("passenger_name")
    private String Passenger_Name;

    @OneToOne
    @JoinColumn(name = "seat_id")
    @JsonIgnore
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    @JsonIgnore
    private Bus bus;

    public String getSeat_Number() {

        return seat != null ? seat.getSeat_number() : null;
    }

    public int getSeatId() {

        return seat != null ? seat.getSeat_id() : 0;
    }

    public String getBus_Travels()
    {

        return bus != null ? bus.getBus_travels() : null;
    }

    public double getPrice()
    {
        return seat != null ? seat.getPrice() : 0;
    }

}
