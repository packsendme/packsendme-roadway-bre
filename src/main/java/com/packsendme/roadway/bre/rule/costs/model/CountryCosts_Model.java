package com.packsendme.roadway.bre.rule.costs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class CountryCosts_Model {
	
	public BicycleCosts_Model bicycle = new BicycleCosts_Model();
	public CarCosts_Model car = new CarCosts_Model();
	public MotorcycleCosts_Model motorcycle = new MotorcycleCosts_Model();
	public TruckCosts_Model truck = new TruckCosts_Model();
	public WalkCosts_Model walking = new WalkCosts_Model();
	
}
