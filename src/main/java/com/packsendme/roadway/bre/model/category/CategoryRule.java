package com.packsendme.roadway.bre.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.roadway.bre.model.location.Location;
import com.packsendme.roadway.bre.model.vehicle.VehicleRule;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CategoryRule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name_category;
	public CategoryType categoryType;
	public Location location;

	public Double weight_min;
	public Double weight_max;
	public Integer axis_max;
	public String unity_measurement_weight_min;
	public String unity_measurement_weight_max;
	public List<VehicleRule> vehicles = new ArrayList<VehicleRule>() ; 
	
	
 	public CategoryRule(String name_category, CategoryType categoryType, Location location, Double weight_min,
			Double weight_max, Integer axis_max, String unity_measurement_weight_min,
			String unity_measurement_weight_max, List<VehicleRule> vehicles) {
		super();
		this.name_category = name_category;
		this.categoryType = categoryType;
		this.location = location;
		this.weight_min = weight_min;
		this.weight_max = weight_max;
		this.axis_max = axis_max;
		this.unity_measurement_weight_min = unity_measurement_weight_min;
		this.unity_measurement_weight_max = unity_measurement_weight_max;
		this.vehicles = vehicles;
	}





	public CategoryRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
 

	
}
