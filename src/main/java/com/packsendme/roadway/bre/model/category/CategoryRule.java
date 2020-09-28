package com.packsendme.roadway.bre.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public String id;
	public CategoryType categoryType = new CategoryType();
	public List<LocationRule> locations = new ArrayList<LocationRule>();
	public List<VehicleRule> vehicles = new ArrayList<VehicleRule>() ; 
	public List<CategoryCosts> categoryCosts = new ArrayList<CategoryCosts>(); 
	
 	public CategoryRule(String id,CategoryType categoryType, List<LocationRule> locations, List<VehicleRule> vehicles,
 			List<CategoryCosts> categoryCosts) {
		super();
		this.id = id;
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
