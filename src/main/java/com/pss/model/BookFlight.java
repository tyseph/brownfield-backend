package com.pss.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class BookFlight {

	@Id
	@GeneratedValue
	private Long bookingId;

	@OneToOne
	private Flight flight;

	private LocalDateTime dateOfBooking;
	private LocalDate dateOfTravelling;
	private Integer noOfPassenger;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengerInfo;

	private String email;
	private String mobileNo;

	public BookFlight() {
		super();
	}

	public BookFlight(Long bookingId, Flight flight, LocalDateTime dateOfBooking, LocalDate dateOfTravelling,
			Integer noOfPassenger, List<Passenger> passengerInfo, String email, String mobileNo) {
		super();
		this.bookingId = bookingId;
		this.flight = flight;
		this.dateOfBooking = dateOfBooking;
		this.dateOfTravelling = dateOfTravelling;
		this.noOfPassenger = noOfPassenger;
		this.passengerInfo = passengerInfo;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public LocalDateTime getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDateTime dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
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

	public List<Passenger> getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(List<Passenger> passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "BookFlight [bookingId=" + bookingId + ", flight=" + flight + ", dateOfBooking=" + dateOfBooking
				+ ", dateOfTravelling=" + dateOfTravelling + ", noOfPassenger=" + noOfPassenger + ", passengerInfo="
				+ passengerInfo + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}

}
