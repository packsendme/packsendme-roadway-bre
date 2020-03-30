package com.packsendme.roadway.bre.rule.instance.model;

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
}
