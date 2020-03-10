package com.packsendme.bre.lib.roadway.rule.instance.model;

import com.packsendme.bre.lib.roadway.rule.costs.model.CarCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class CarInstance_Model {
	
	public Double distance_max_car;
	public Double weight_max_car;
	public Double percentage_rate_availability_car;
	public CarCosts_Model carCosts = new CarCosts_Model();
		
}
