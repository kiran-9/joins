package com.joins.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="available_location")
public class LocationPOJO {
	
	@Id
	@Column(name = "location_picode")
	private int pincode;
	private String location;
	private String country;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_fk")
	private CarsPOJO cars;
	
	public CarsPOJO getCars() {
		return cars;
	}
	public void setCars(CarsPOJO cars) {
		this.cars = cars;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
