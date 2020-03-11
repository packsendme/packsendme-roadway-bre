package com.packsendme.bre.lib.roadway.rule.costs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class TruckCosts_Model {
	
	public Double cost_weight_truck;
	public Double cost_distance_truck;
	public Double cost_variable_truck;
	public Double percentage_reshipping_truck;
	public Double percentage_storage_truck;
	public Double percentage_rate_availability;
}
