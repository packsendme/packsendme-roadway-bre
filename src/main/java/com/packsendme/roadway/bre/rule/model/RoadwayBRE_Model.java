package com.packsendme.roadway.bre.rule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.packsendme.roadway.bre.rule.costs.model.CountryCosts_Model;
import com.packsendme.roadway.bre.rule.instance.model.BicycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.CarInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.MotorcycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.TruckInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.WalkingInstance_Model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
//@RedisHash("RoadwayBRE")
public class RoadwayBRE_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int id_rule = 1;
	public Date date_creation;
	public String date_change;
	public String unity_measurement_weight;
	public String unity_measurement_distance;
	public String currency_cost;
	public String status;
	
	public BicycleInstance_Model bicycle = new BicycleInstance_Model();
	public CarInstance_Model car = new CarInstance_Model();
	public MotorcycleInstance_Model motorcycle = new MotorcycleInstance_Model();
	public TruckInstance_Model truck = new TruckInstance_Model();
	public WalkingInstance_Model walking = new WalkingInstance_Model();
	
	public ArrayList<CountryCosts_Model> costsCountry = new ArrayList<CountryCosts_Model>();
}
