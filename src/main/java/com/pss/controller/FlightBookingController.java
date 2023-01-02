package com.pss.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	// To create a new booking
	@PostMapping("/bookFlight")
	public BookFlight newFlightBooking(@RequestBody BookFlight newBooking) {
		return bookFlightService.bookFlight(newBooking);
	}

	// To get booking by booking id
	@GetMapping("/getBooking/{bookingId}")
	public BookFlight getBooking(@PathVariable("bookingId") Long bookingId) {
		return bookFlightService.getBooking(bookingId);
	}

	// can cancel a booking
	@DeleteMapping("/cancelBooking/{bookingId}")
	public String cancelBooking(@PathVariable("bookingId") Long bookingId) {
		return bookFlightService.cancelBooking(bookingId);
	}

	// To get all the bookings. Admin can view all the bookings
	@GetMapping("/getAllBooking")
	public List<BookFlight> getAllBookings() {
		return bookFlightService.getAllBookings();
	}

	// To get booking by selected date. Admin can view all the bookings of a
	// particular date
	@GetMapping("/getBookingByDate")
	public List<BookFlight> getBookingByDate(@RequestBody LocalDate date) {
		return bookFlightService.getBookingByDate(date);
	}

	// To get all the booked seats
	@GetMapping("/getBookedSeats/{flightId}/{date}")
	public Collection<Integer> getBookedSeats(@PathVariable("flightId") Long flightId,
			@PathVariable("date") LocalDate date) {
		return bookFlightService.getBookedSeats(flightId, date);
	}

	// To get all booked flights between two cities on given date
	@GetMapping("/getBookedFlights")
	public List<BookFlight> getBookedFlights(@RequestBody Map<String, String> request) {
		return bookFlightService.getBookedFlights(request.get("source"), request.get("destination"),
				LocalDate.parse(request.get("date")));
	}

}
