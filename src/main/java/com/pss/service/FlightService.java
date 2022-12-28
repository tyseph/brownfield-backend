package com.pss.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.dao.FlightRepo;
import com.pss.model.Flight;

@Service
public class FlightService {
	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		// The math module contains a function
		// named toRadians which converts from
		// degrees to radians.
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers. Use 3956
		// for miles
		double r = 6371;

		// calculate the result
		return (c * r);
	}

	@Autowired
	private FlightRepo flightRepo;

	public Flight addFlight(Flight newFlight) {

		// Calculate the distance between two airports
		newFlight.setDistance(distance(newFlight.getSource().getLat(), newFlight.getDestination().getLat(),
				newFlight.getSource().getLon(), newFlight.getDestination().getLon()));

		// Set DepartureTime
		newFlight.setDepartureTime(LocalTime.parse(newFlight.getTimeOfDeparture(), DateTimeFormatter.ISO_TIME));

		// Set ArrivalTime
		newFlight.setArrivalTime(LocalTime.parse(newFlight.getTimeOfArrival(), DateTimeFormatter.ISO_TIME));

		return flightRepo.saveAndFlush(newFlight);
	}

	public Optional<Flight> getFlightById(Long flightId) {
		if (!flightRepo.existsById(flightId)) {
			return Optional.empty();
		}

		return flightRepo.findById(flightId);
	}

	public List<Flight> getAllFlight() {
		return flightRepo.findAll();
	}

}
