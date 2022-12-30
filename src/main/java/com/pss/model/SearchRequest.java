package com.pss.model;

import java.time.LocalDate;

public class SearchRequest {

	private Airport source;
	private Airport destination;
	private LocalDate dateOfTravelling;
	private Integer noOfPassenger;

	public SearchRequest() {
		super();
	}

	public SearchRequest(Airport source, Airport destination, LocalDate dateOfTravelling, Integer noOfPassenger) {
		super();
		this.source = source;
		this.destination = destination;
		this.dateOfTravelling = dateOfTravelling;
		this.noOfPassenger = noOfPassenger;
	}

	public Airport getSource() {
		return source;
	}

	public void setSource(Airport source) {
		this.source = source;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public LocalDate getDateOfTravelling() {
		return dateOfTravelling;
	}

	public void setDateOfTravelling(LocalDate dateOfTravelling) {
		this.dateOfTravelling = dateOfTravelling;
	}

	public Integer getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(Integer noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	@Override
	public String toString() {
		return "SearchRequest [source=" + source + ", destination=" + destination + ", dateOfTravelling="
				+ dateOfTravelling + ", noOfPassenger=" + noOfPassenger + "]";
	}

}
