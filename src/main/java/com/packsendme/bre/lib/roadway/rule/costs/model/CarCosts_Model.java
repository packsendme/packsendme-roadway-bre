package com.packsendme.bre.lib.roadway.rule.costs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class CarCosts_Model {
	
	public Double cost_weight_car;
	public Double cost_distance_car;
	public Double cost_variable_car;
	public Double percentage_reshipping_car;
	public Double percentage_storage_car;
	public Double percentage_rate_availability;
			
}
