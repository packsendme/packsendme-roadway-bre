package com.packsendme.bre.lib.roadway.rule.instance.model;

import com.packsendme.bre.lib.roadway.rule.costs.model.MotorcycleCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MotorcycleInstance_Model {
	
	public Double distance_max_motorcycle;
	public Double weight_max_motorcycle;
	public Double percentage_rate_availability_motorcycle;
	public MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
		
}
