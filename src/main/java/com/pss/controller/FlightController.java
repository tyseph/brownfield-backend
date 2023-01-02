package com.pss.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pss.model.Airport;
import com.pss.model.Flight;
import com.pss.model.SearchRequest;
import com.pss.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	// Admin can add flight
	@PostMapping("/addFlight")
	public Flight addFlight(@RequestBody Flight newFlight) {
		return flightService.addFlight(newFlight);
	}

	// Admin remove flight
	@DeleteMapping("/removeFlight/{flightId}")
	public String removeFlight(@PathVariable("flightId") Long flightId) {
		return flightService.removeFlight(flightId);
	}

	// Admin can edit flight
	@PatchMapping("/editFlight/{flightId}")
	public Flight editFlight(@PathVariable("flightId") Long flightId, @RequestBody Flight updatedFlight) {
		return flightService.editFlight(flightId, updatedFlight);
	}

	// To get flight by flightId
	@GetMapping("/getFlight/{flightId}")
	public Flight getFlightById(@PathVariable("flightId") Long flightId) {
		return flightService.getFlightById(flightId).get();
	}

	// Admin can get all flights
	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlight();
	}

	// To get flight by source and destination city
	@GetMapping("/search")
	public List<Flight> searchFlight(@RequestBody Map<String, Airport> airports) {
		return flightService.getFlightBySourceAndDestination(airports.get("source"), airports.get("destination"));
	}

	// To get flight by source, destination, date and no. of passenger
	@GetMapping("/search1")
	public List<Flight> searchFlight(@RequestBody SearchRequest searchRequest) {
		return flightService.searchFlight(searchRequest);
	}

	// To get flight which runs in morning
	@GetMapping("/morningFlights")
	public List<Flight> morningFlights() {
		return flightService.getMorningFlights();
	}

	// To get flight which runs in afternoon
	@GetMapping("/afternoonFlights")
	public List<Flight> afternoonFlights() {
		return flightService.getAfternoonFlights();
	}

	// To get flight which runs in night
	@GetMapping("/nightFlights")
	public List<Flight> nightFlights() {
		return flightService.getNightFlights();
	}

}
