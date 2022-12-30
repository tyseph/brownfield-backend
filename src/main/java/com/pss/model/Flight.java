package com.pss.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Flight {

	@Id
	private Long flightId;

	@OneToOne
	private Airport source;

	@OneToOne
	private Airport destination;

	private Double distance;

	@Transient
	private String timeOfDeparture;

	@Transient
	private String timeOfArrival;

	private LocalTime departureTime;
	private LocalTime arrivalTime;

	public Flight() {
		super();
	}

	public Flight(Long flightId, Airport source, Airport destination, Double distance, String timeOfDeparture,
			String timeOfArrival, LocalTime departureTime, LocalTime arrivalTime) {
		super();
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.timeOfDeparture = timeOfDeparture;
		this.timeOfArrival = timeOfArrival;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public Long getFlightId() {
		return flightId;
	}

	public Airport getSource() {
		return source;
	}

	public Airport getDestination() {
		return destination;
	}

	public Double getDistance() {
		return distance;
	}

	public String getTimeOfDeparture() {
		return timeOfDeparture;
	}

	public String getTimeOfArrival() {
		return timeOfArrival;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public void setSource(Airport source) {
		this.source = source;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public void setTimeOfDeparture(String timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}

	public void setTimeOfArrival(String timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", distance="
				+ distance + ", timeOfDeparture=" + timeOfDeparture + ", timeOfArrival=" + timeOfArrival
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

}
