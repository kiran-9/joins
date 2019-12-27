package com.joins.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="drivinglicence")
public class LicencePOJO {
	
	@Id
	private String licence_number;
	private String location;
	private String issued_year;
	private String expired_year;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private PeoplePOJO people;
	
	
	
	public PeoplePOJO getPeople() {
		return people;
	}
	public void setPeople(PeoplePOJO people) {
		this.people = people;
	}
	public String getLicence_number() {
		return licence_number;
	}
	public void setLicence_number(String licence_number) {
		this.licence_number = licence_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIssued_year() {
		return issued_year;
	}
	public void setIssued_year(String issued_year) {
		this.issued_year = issued_year;
	}
	public String getExpired_year() {
		return expired_year;
	}
	public void setExpired_year(String expired_year) {
		this.expired_year = expired_year;
	}
	
	

}
