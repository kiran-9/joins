package com.joins.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class PeoplePOJO {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String mobile_number;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "people")
	@JoinColumn(name="person_id")
	private LicencePOJO licence;
	
	
	public LicencePOJO getLicence() {
		return licence;
	}
	public void setLicence(LicencePOJO licence) {
		this.licence = licence;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

}
