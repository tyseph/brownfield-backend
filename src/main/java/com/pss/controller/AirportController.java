package com.pss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("/addAirport")
	public String addAirport(@RequestBody Airport newAirport) {
		return airportService.addAirport(newAirport);
	}

	@PostMapping("/addAirports")
	public String addAirport(@RequestBody List<Airport> airports) {
		for (Airport airport : airports)
			airportService.addAirport(airport);
		return "Added successfully";
	}

	@GetMapping("/getAirport/{code}")
	public Airport getAirport(@PathVariable("code") String code) {
		return airportService.getAirportByCode(code).get();
	}

	@GetMapping("/getAllAirports")
	public List<Airport> getAllAirports() {
		return airportService.getAllAirports();
	}
}
