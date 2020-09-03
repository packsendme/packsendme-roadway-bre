package com.packsendme.roadway.bre.model.category;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CategoryType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name_category;
	public String transport_type;
	public Double weight_min;
	public Double weight_max;
	public String unity_measurement_weight_min;
	public String unity_measurement_weight_max;
	
	public CategoryType(String name_category, String transport_type, Double weight_min, Double weight_max,
			String unity_measurement_weight_min, String unity_measurement_weight_max) {
		super();
		this.name_category = name_category;
		this.transport_type = transport_type;
		this.weight_min = weight_min;
		this.weight_max = weight_max;
		this.unity_measurement_weight_min = unity_measurement_weight_min;
		this.unity_measurement_weight_max = unity_measurement_weight_max;
	}

	
}
