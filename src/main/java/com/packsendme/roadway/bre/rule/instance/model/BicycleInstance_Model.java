package com.packsendme.roadway.bre.rule.instance.model;

import com.packsendme.roadway.bre.rule.costs.model.BicycleCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class BicycleInstance_Model {
	
	public Double distance_max_bicycle;
	public Double weight_max_bicycle;
	public Double percentage_rate_availability_bicycle;
	public BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();

}
