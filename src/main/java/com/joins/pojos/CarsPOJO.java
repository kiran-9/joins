package com.joins.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class CarsPOJO {
	
	@Id
	private String model;
	private String color;
	private String varient;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_fk")
	private List<LocationPOJO> location;
	
	
	
	public List<LocationPOJO> getLocation() {
		return location;
	}
	public void setLocation(List<LocationPOJO> location) {
		this.location = location;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVarient() {
		return varient;
	}
	public void setVarient(String varient) {
		this.varient = varient;
	}
	

}
