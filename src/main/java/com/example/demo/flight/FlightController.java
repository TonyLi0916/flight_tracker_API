package com.example.demo.flight;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    // constructor
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // to retrieve all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // to retrieve a single flight by flight number
    @GetMapping("/{flightNumber}")
    public Flight getFlightByNumber(@PathVariable String flightNumber) {
        return flightService.getFlightByNumber(flightNumber);
    }

    // to add a new flight
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    // to update a flight
    @PutMapping("/{flightNumber}")
    public Flight updateFlight(@PathVariable String flightNumber, @RequestBody Flight updatedFlight) {
        return flightService.updateFlight(flightNumber, updatedFlight);
    }

    // to delete a flight by flight number
    @DeleteMapping("/{flightNumber}")
    public String deleteFlight(@PathVariable String flightNumber) {
        flightService.deleteFlight(flightNumber);
        return "Flight deleted successfully!";
    }
}
