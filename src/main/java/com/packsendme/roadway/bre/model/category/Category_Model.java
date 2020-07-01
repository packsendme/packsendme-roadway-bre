package com.packsendme.roadway.bre.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.roadway.bre.model.vehicle.Vehicle_Model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class Category_Model implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name_category;
	public List<Vehicle_Model> vehicle_ModelL = new ArrayList<Vehicle_Model>() ; 
	public Double weight_min;
	public Double weight_max;
	public Integer axis_max;
	public String unity_measurement_weight_min;
	public String unity_measurement_weight_max;
	
	
	public Category_Model(String name_category, List<Vehicle_Model> vehicle_ModelL, Double weight_min,
			Double weight_max, Integer axis_max, String unity_measurement_weight_min, String unity_measurement_weight_max) {
		super();
		this.name_category = name_category;
		this.vehicle_ModelL = vehicle_ModelL;
		this.weight_min = weight_min;
		this.weight_max = weight_max;
		this.axis_max = axis_max;
		this.unity_measurement_weight_min = unity_measurement_weight_min;
		this.unity_measurement_weight_max = unity_measurement_weight_max;
	}


	public Category_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
 

	
}
