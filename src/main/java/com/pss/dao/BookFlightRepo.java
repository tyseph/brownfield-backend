package com.pss.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pss.model.BookFlight;

@Repository
public interface BookFlightRepo extends JpaRepository<BookFlight, Long> {

	@Query("SELECT b FROM BookFlight b WHERE b.dateOfTravelling = ?1")
	public List<BookFlight> getBookingByDate(LocalDate date);

	@Query(value = "select sum(no_of_passenger) from book_flight where flight_flight_id in (select flight_flight_id from book_flight where flight_flight_id = ?1) and date_of_travelling = ?2", nativeQuery = true)
	public Integer getPassengerCount(Long flightId, LocalDate date);

}
