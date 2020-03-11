package com.packsendme.roadway.bre.rule.instance.model;

import com.packsendme.roadway.bre.rule.costs.model.WalkCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class WalkingInstance_Model {
	
	public Double distance_max_walking;
	public Double weight_max_walking;
	public Double percentage_rate_availability_walking;
	public WalkCosts_Model walkingCosts = new WalkCosts_Model();
	
}
