package com.packsendme.roadway.bre.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.roadway.bre.model.vehicle.VehicleRule;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String id;
	public String name_category;
	public String transport;
	public Double weight_min;
	public Double weight_max;
	public String unity_measurement_weight_min;
	public String unity_measurement_weight_max;
	public List<VehicleRule> vehicles = new ArrayList<VehicleRule>() ; 
	
	public Category(String name_category, String transport, Double weight_min, Double weight_max,
			String unity_measurement_weight_min, String unity_measurement_weight_max, List<VehicleRule> vehicles) {
		super();
		this.name_category = name_category;
		this.transport = transport;
		this.weight_min = weight_min;
		this.weight_max = weight_max;
		this.unity_measurement_weight_min = unity_measurement_weight_min;
		this.unity_measurement_weight_max = unity_measurement_weight_max;
		this.vehicles = vehicles;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
