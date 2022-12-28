package com.pss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Airport {

	@Id
	private String code;
	private String name;
	private String city;
	private String state;
	private String country;
	private Double lat;
	private Double lon;
	private Integer elev;

	public Airport() {
		super();
	}

	public Airport(String code, String name, String city, String state, String country, Double lat, Double lon,
			Integer elev) {
		super();
		this.code = code;
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
		this.elev = elev;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

	public Integer getElev() {
		return elev;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public void setElev(Integer elev) {
		this.elev = elev;
	}

}
