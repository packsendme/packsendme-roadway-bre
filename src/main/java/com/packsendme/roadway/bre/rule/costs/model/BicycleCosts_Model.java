package com.packsendme.roadway.bre.rule.costs.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class BicycleCosts_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Employee cost for delivery
	public Double cost_weight_bicycle;
	public Double cost_distance_bicycle;

	// Percentage PackSendMe
	public Double percentage_reshipping_bicycle;
	public Double percentage_rate_availability;

}
