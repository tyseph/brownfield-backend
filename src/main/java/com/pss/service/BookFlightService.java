package com.pss.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.dao.BookFlightRepo;
import com.pss.model.BookFlight;

@Service
public class BookFlightService {

	@Autowired
	private BookFlightRepo bookFlightRepo;

	// To book a flight
	public BookFlight bookFlight(BookFlight newBooking) {
		newBooking.setDateOfBooking(LocalDateTime.now());
		return bookFlightRepo.saveAndFlush(newBooking);
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
}
