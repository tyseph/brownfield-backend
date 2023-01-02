package com.pss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pss.model.Airport;
import com.pss.service.AirportService;

@RestController
@CrossOrigin(origins = "*")
public class AirportController {

	@Autowired
	private AirportService airportService;

	// Admin Service
	// Add Airport
	@PostMapping("/addAirport")
	public String addAirport(@RequestBody Airport newAirport) {
		return airportService.addAirport(newAirport);
	}

	// Admin Service
	// Add list of airports
	@PostMapping("/addAirports")
	public String addAirport(@RequestBody List<Airport> airports) {
		for (Airport airport : airports)
			airportService.addAirport(airport);
		return "Added successfully";
	}

	// Admin Service
	// Delete airport by code
	@DeleteMapping("/deleteAirport")
	public String removeAirport(String code) {
		return airportService.removeAirport(code);
	}

	// Admin Service
	// Update airport by airport code
	@PatchMapping("/updateAirport/{code}")
	public Airport updateAirport(@PathVariable("code") String code, @RequestBody Airport updatedAirport) {
		return airportService.updateAirport(code, updatedAirport);
	}

	// Get airport by airport code
	@GetMapping("/getAirport/{code}")
	public Airport getAirport(@PathVariable("code") String code) {
		return airportService.getAirportByCode(code).get();
	}

	// Get all airports
	@GetMapping("/getAllAirports")
	public List<Airport> getAllAirports() {
		return airportService.getAllAirports();
	}

}
