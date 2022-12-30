package com.pss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.dao.AirportRepo;
import com.pss.model.Airport;

@Service
public class AirportService {

	@Autowired
	private AirportRepo airportRepo;

	// Admin Services
	// Add Airport
	public String addAirport(Airport newAirport) {
		airportRepo.saveAndFlush(newAirport);

		return "Airport added.";
	}

	// Admin Service
	// Remove Airport by code
	public String removeAirport(String code) {
		if (!airportRepo.existsById(code)) {
			return "Airport doesn't exist";
		}
		airportRepo.deleteById(code);
		return "Airport removed";
	}

	public Optional<Airport> getAirportByCode(String code) {
		if (!airportRepo.existsById(code)) {
			return Optional.empty();
		}

		return airportRepo.findById(code);
	}

	// Admin Service
	// Get all airports
	public List<Airport> getAllAirports() {
		return airportRepo.findAll();
	}

}
