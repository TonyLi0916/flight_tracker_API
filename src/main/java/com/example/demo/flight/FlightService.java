package com.example.demo.flight;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    // constructor
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightByNumber(String flightNumber) {
        return flightRepository.findById(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight:" + flightNumber + "not found"));
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(String flightNumber, Flight updatedFlight) {

            // find by id
            Flight existingFlight = flightRepository.findById(flightNumber)
                    .orElseThrow(() -> new RuntimeException("Flight:" + flightNumber + "not found"));

            // update
            existingFlight.setOrigin(updatedFlight.getOrigin());
            existingFlight.setDestination(updatedFlight.getDestination());
            existingFlight.setStatus(updatedFlight.getStatus());

            // save and return
            return flightRepository.save(existingFlight);
    }

    public void deleteFlight(String flightNumber) {
        flightRepository.deleteById(flightNumber);
    }


}

