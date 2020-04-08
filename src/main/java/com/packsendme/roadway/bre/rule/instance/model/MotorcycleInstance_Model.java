package com.packsendme.roadway.bre.rule.instance.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MotorcycleInstance_Model implements Serializable {
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Double distance_max_motorcycle;
	public Double weight_max_motorcycle;
	public Double percentage_rate_availability_motorcycle;		
}
