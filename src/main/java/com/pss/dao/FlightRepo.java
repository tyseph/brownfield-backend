package com.pss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pss.model.Airport;
import com.pss.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

	@Query("SELECT f FROM Flight f WHERE f.source = ?1 and f.destination = ?2")
	public List<Flight> findBySourceAndDestination(Airport source, Airport destination);

}
