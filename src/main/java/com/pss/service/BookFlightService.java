package com.pss.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.dao.BookFlightRepo;
import com.pss.model.BookFlight;
import com.pss.model.Passenger;

@Service
public class BookFlightService {

	@Autowired
	private BookFlightRepo bookFlightRepo;

	// To book a flight
	public BookFlight bookFlight(BookFlight newBooking) {

		// Get all the booked seats
		Collection<Integer> bookedSeats = bookFlightRepo.getBookedSeat(newBooking.getFlight().getFlightId(),
				newBooking.getDateOfTravelling());

		// assign next available seat to passenger
		for (Passenger passenger : newBooking.getPassengerInfo()) {
			if (passenger.getSeatNo() == null) {
				for (int i = 1; i < 101; i++) {
					if (!bookedSeats.contains(i)) {
						passenger.setSeatNo(i);
						break;
					}
				}
			} else {
				if (bookedSeats.contains(passenger.getSeatNo())) {
					// Throws error here
					System.out.println("Error");
				}
			}
		}

		// set date of booking as now
		newBooking.setDateOfBooking(LocalDateTime.now());

		return bookFlightRepo.saveAndFlush(newBooking);
	}

	// Delete booking
	public String cancelBooking(Long bookingId) {
		if (!bookFlightRepo.existsById(bookingId)) {
			return "Booking doesn't exist";
		}

		bookFlightRepo.deleteById(bookingId);
		return "Booking removed successfully";
	}

	// To get booking
	public BookFlight getBooking(Long bookingId) {
		if (!bookFlightRepo.existsById(bookingId)) {
			return null;
		}
		return bookFlightRepo.findById(bookingId).get();
	}

	// Get All the bookings
	public List<BookFlight> getAllBookings() {
		return bookFlightRepo.findAll();
	}

	// Get booking by date
	public List<BookFlight> getBookingByDate(LocalDate date) {
		return bookFlightRepo.getBookingByDate(date);
	}

	// Get booked seats
	public Collection<Integer> getBookedSeats(Long flightId, LocalDate date) {
		return bookFlightRepo.getBookedSeat(flightId, date);
	}

	// Get booked flights between two cities on given date
	public List<BookFlight> getBookedFlights(String source, String destination, LocalDate date) {
		return bookFlightRepo.getBookedFlights(source, destination, date).stream().toList();
	}
}
