package com.packsendme.roadway.bre.rule.instance.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RuleInstance_Model implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BicycleInstance_Model bicycle = new BicycleInstance_Model();
	public CarInstance_Model car = new CarInstance_Model();
	public MotorcycleInstance_Model motorcycle = new MotorcycleInstance_Model();
	public TruckInstance_Model truck = new TruckInstance_Model();
	public WalkingInstance_Model walking = new WalkingInstance_Model();

}
