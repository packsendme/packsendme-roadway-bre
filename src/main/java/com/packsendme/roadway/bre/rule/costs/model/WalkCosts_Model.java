package com.packsendme.roadway.bre.rule.costs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class WalkCosts_Model {
	
	public Double cost_weight_walk;
	public Double cost_distance_walk;
	public Double cost_variable_walk;
	public Double percentage_reshipping_walk;
	public Double percentage_storage_walk;
	public Double percentage_rate_availability;
	
}
