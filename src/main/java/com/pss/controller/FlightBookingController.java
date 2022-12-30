package com.pss.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pss.model.BookFlight;
import com.pss.service.BookFlightService;

@RestController
public class FlightBookingController {

	@Autowired
	private BookFlightService bookFlightService;

	@PostMapping("/bookFlight")
	public BookFlight newFlightBooking(@RequestBody BookFlight newBooking) {
		return bookFlightService.bookFlight(newBooking);
	}

	@GetMapping("/getBooking/{bookingId}")
	public BookFlight getBooking(@PathVariable("bookingId") Long bookingId) {
		return bookFlightService.getBooking(bookingId);
	}

	@GetMapping("/getAllBooking")
	public List<BookFlight> getAllBookings() {
		return bookFlightService.getAllBookings();
	}

	@GetMapping("/getBookingByDate")
	public List<BookFlight> getBookingByDate(@RequestBody LocalDate date) {
		return bookFlightService.getBookingByDate(date);
	}

}
