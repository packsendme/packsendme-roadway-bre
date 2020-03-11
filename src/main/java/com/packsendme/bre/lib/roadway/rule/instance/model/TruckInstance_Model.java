package com.packsendme.bre.lib.roadway.rule.instance.model;

import com.packsendme.bre.lib.roadway.rule.costs.model.TruckCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class TruckInstance_Model {

	public boolean allow_cross_continent_truck;
	public Double weight_max_truck;
	public Double percentage_rate_availability_truck;
	public TruckCosts_Model truckCosts = new TruckCosts_Model();
		
}
