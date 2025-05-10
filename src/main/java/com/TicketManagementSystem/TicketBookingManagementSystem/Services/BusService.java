package com.TicketManagementSystem.TicketBookingManagementSystem.Services;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Bus;
import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Seat;
import com.TicketManagementSystem.TicketBookingManagementSystem.Repositories.BusRepository;
import com.TicketManagementSystem.TicketBookingManagementSystem.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private SeatRepository seatRepository;

    public List<Bus> getAllBus()
    {
        return busRepository.findAll();
    }
    public Optional<Bus> getBus(int id)
    {
        return busRepository.findById(id);
    }
    public Bus addBus(Bus bus)
    {
        if (bus.getSeats() != null) {
            for (Seat seat : bus.getSeats()) {
                seat.setBus(bus);
            }
        }
        return busRepository.save(bus);
    }
    public Bus updateBus(int id,Bus busdetails)
    {
        Optional<Bus> existingBusOptional = busRepository.findById(id);

        if (existingBusOptional.isPresent()) {
            Bus existingBus = existingBusOptional.get();

            existingBus.setSeats(busdetails.getSeats());

            return busRepository.save(existingBus);
        } else {
            throw new RuntimeException("Bus not found with id: " + id);
        }
    }
    public void deleteBus(int id)
    {
        Optional<Bus> bus = busRepository.findById(id);

        for (Seat seat : bus.get().getSeats()) {
            seatRepository.deleteById(seat.getSeat_id());
        }
        busRepository.deleteById(id);
    }
}

