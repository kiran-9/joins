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
@Table(name = "service")
public class Service {
	
	@Id
	@Column(name = "service_id")
	private int serviceId;
	
	@Column(name = "service_type")
	private String type;
	
	@Column(name = "location")
	private String location;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "clint_service",   
            joinColumns = { @JoinColumn(name = "service_fk") },   
            inverseJoinColumns = { @JoinColumn(name = "clint_fk") })  
	private List<Clint> clint;
	
	
	public List<Clint> getClint() {
		return clint;
	}
	public void setClint(List<Clint> clint) {
		this.clint = clint;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
