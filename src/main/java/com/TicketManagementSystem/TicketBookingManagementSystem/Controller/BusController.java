package com.TicketManagementSystem.TicketBookingManagementSystem.Controller;

import com.TicketManagementSystem.TicketBookingManagementSystem.Model.Bus;
import com.TicketManagementSystem.TicketBookingManagementSystem.Services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> getAllBuses()
    {
        return busService.getAllBus();
    }

    @GetMapping("/{id}")
    public Optional<Bus> getBusById(@PathVariable int id)
    {
        return busService.getBus(id);
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus)
    {
        return busService.addBus(bus);
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable int id, @RequestBody Bus bus)
    {
        return busService.updateBus(id,bus);
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable int id)
    {
        busService.deleteBus(id);
    }
}
