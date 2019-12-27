package com.joins.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clint")
public class Clint {
	
	@Id
	@Column(name = "clint_name")
	private String name;
	
	@Column(name = "corp_office")
	private String office;
	
	@Column(name = "no_of_employees")
	private int empliyees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "clint_service",   
            joinColumns = { @JoinColumn(name = "clint_fk") },   
            inverseJoinColumns = { @JoinColumn(name = "service_fk") })  
	
	private List<Service> service;
	
	public List<Service> getService() {
		return service;
	}
	public void setService(List<Service> service) {
		this.service = service;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public int getEmpliyees() {
		return empliyees;
	}
	public void setEmpliyees(int empliyees) {
		this.empliyees = empliyees;
	}

}
