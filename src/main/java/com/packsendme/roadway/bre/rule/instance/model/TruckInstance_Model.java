package com.packsendme.roadway.bre.rule.instance.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class TruckInstance_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean allow_cross_continent_truck;
	public Double weight_max_truck;

	// Percentage PackSendMe
	public Double percentage_reshipping;
	public Double percentage_rate_availability;
}
