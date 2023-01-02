package com.pss.dao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pss.model.BookFlight;

@Repository
public interface BookFlightRepo extends JpaRepository<BookFlight, Long> {

	// get booked flights for data
	@Query("SELECT b FROM BookFlight b WHERE b.dateOfTravelling = ?1")
	public List<BookFlight> getBookingByDate(LocalDate date);

	// get passenger count for a flight
	@Query(value = "select sum(no_of_passenger) from book_flight where flight_flight_id in (select flight_flight_id from book_flight where flight_flight_id = ?1) and date_of_travelling = ?2", nativeQuery = true)
	public Integer getPassengerCount(Long flightId, LocalDate date);

	// Get Booked Seats
	@Query(value = "select p.seat_no from book_flight join book_flight_passenger_info on book_flight_booking_id = booking_id join passenger p on passenger_info_passenger_id = passenger_id where flight_flight_id = ?1 and date_of_travelling = ?2", nativeQuery = true)
	public Collection<Integer> getBookedSeat(Long flightId, LocalDate date);

	// Get booked flights between two cities on given date
	@Query(value = "SELECT b FROM BookFlight b WHERE b.flight.source.code = ?1 and b.flight.destination.code = ?2 and b.dateOfTravelling = ?3", nativeQuery = false)
	public Collection<BookFlight> getBookedFlights(String source, String destination, LocalDate date);

}
