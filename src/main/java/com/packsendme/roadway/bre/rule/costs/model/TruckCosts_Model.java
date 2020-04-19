package com.packsendme.roadway.bre.rule.costs.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class TruckCosts_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Fixed based cost (weight, distance...)
	public Double weight_cost;
	public Double distance_cost;
	public Double average_consumption_cost;
	
	// Fixed delivery cost (tolls, fuel...)
	public Double tolls_average_cost;
	public Double fuel_average_cost;

	// Percentage PackSendMe
	public Double percentage_reshipping_bicycle;
	public Double percentage_rate_availability;
}
