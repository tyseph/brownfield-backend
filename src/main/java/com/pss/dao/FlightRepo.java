package com.pss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

}
