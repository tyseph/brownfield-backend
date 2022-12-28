package com.pss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.model.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, String> {

}
