package com.packsendme.roadway.bre.rule.costs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class WalkCosts_Model {
	
	// Fixed based cost (weight, distance...)
	public Double weight_cost;
	public Double distance_cost;

	// Percentage PackSendMe
	public Double percentage_reshipping_bicycle;
	public Double percentage_rate_availability;
}
