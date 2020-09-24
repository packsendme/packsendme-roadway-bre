package com.packsendme.roadway.bre.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.packsendme.roadway.bre.model.location.LocationRule;
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
	
	public CategoryType categoryType = new CategoryType();
	public List<LocationRule> locations = new ArrayList<LocationRule>();
	public List<VehicleRule> vehicles = new ArrayList<VehicleRule>() ; 
	public Map<String,List<CategoryCosts>> categoryCosts = new HashMap<>(); 
	
 	public CategoryRule(CategoryType categoryType, List<LocationRule> locations, List<VehicleRule> vehicles,
 			Map<String,List<CategoryCosts>> categoryCosts) {
		super();
		this.categoryType = categoryType;
		this.locations = locations;
		this.vehicles = vehicles;
		this.categoryCosts = categoryCosts;
	}

	public CategoryRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
