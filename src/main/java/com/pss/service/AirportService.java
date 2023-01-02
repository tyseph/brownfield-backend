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

	// Admin Service
	// Update airport
	public Airport updateAirport(String code, Airport updatedAirport) {
		if (!airportRepo.existsById(code)) {
			return null;
		}

		Airport airportToUpdate = airportRepo.findById(code).get();

		airportToUpdate.setCity(updatedAirport.getCity());
		airportToUpdate.setState(updatedAirport.getState());
		airportToUpdate.setCountry(updatedAirport.getCountry());
		airportToUpdate.setName(updatedAirport.getName());
		airportToUpdate.setLat(updatedAirport.getLat());
		airportToUpdate.setLon(updatedAirport.getLon());
		airportToUpdate.setElev(updatedAirport.getElev());

		return airportRepo.saveAndFlush(airportToUpdate);

	}

	// Get Airport by code
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
