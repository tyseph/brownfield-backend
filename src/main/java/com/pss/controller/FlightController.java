package com.pss.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pss.model.Airport;
import com.pss.model.Flight;
import com.pss.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping("/addFlight")
	public Flight addFlight(@RequestBody Flight newFlight) {
		return flightService.addFlight(newFlight);
	}

	@GetMapping("/getFlight/{flightId}")
	public Flight getFlightById(@PathVariable("flightId") Long flightId) {
		return flightService.getFlightById(flightId).get();
	}

	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlight();
	}

	@GetMapping("/search")
	public List<Flight> searchFlight(@RequestBody Map<String, Airport> airports) {
		return flightService.getFlightBySourceAndDestination(airports.get("source"), airports.get("destination"));
	}
}
