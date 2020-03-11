package com.packsendme.roadway.bre.rule.costs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class BicycleCosts_Model {

	public Double cost_weight_bicycle;
	public Double cost_distance_bicycle;
	public Double cost_variable_bicycle;
	public Double percentage_reshipping_bicycle;
	public Double percentage_storage_bicycle;
	public Double percentage_rate_availability;

}
