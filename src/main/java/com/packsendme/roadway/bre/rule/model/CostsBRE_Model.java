package com.packsendme.roadway.bre.rule.model;

import java.util.Date;

import com.packsendme.roadway.bre.rule.costs.model.BicycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.CarCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.MotorcycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.TruckCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.WalkCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class CostsBRE_Model {
	
	public BicycleCosts_Model bicycle = new BicycleCosts_Model();
	public CarCosts_Model car = new CarCosts_Model();
	public MotorcycleCosts_Model motorcycle = new MotorcycleCosts_Model();
	public TruckCosts_Model truck = new TruckCosts_Model();
	public WalkCosts_Model walking = new WalkCosts_Model();
	
}
