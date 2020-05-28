package com.packsendme.roadway.bre.rule.costs.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RuleCosts_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Fixed based cost (weight, distance...)
	public Double weight_cost;
	public Double distance_cost;
	public Double worktime_cost;
	public Double average_consumption_cost;

	// Fixed delivery cost (tolls, fuel...)
	public Double tolls_average_cost;
	public Double fuel_average_cost;
	public Double rate_exchange;
	
	// Percentage 
	public Double rate_availability;


	
	public RuleCosts_Model(Double weight_cost, Double distance_cost, Double worktime_cost, Double average_consumption_cost,
			Double tolls_average_cost, Double fuel_average_cost, Double rate_exchange, Double rate_availability) {
		super();
		this.weight_cost = weight_cost;
		this.distance_cost = distance_cost;
		this.worktime_cost = worktime_cost;
		this.average_consumption_cost = average_consumption_cost;
		this.tolls_average_cost = tolls_average_cost;
		this.fuel_average_cost = fuel_average_cost;
		this.rate_exchange = rate_exchange;
		this.rate_availability = rate_availability;
	}

	public RuleCosts_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
