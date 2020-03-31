package com.packsendme.roadway.bre.rule.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.packsendme.roadway.bre.rule.costs.model.CountryCosts_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class RoadwayCostsBRE_Model {
	
	public int id_rule;
	public Date date_creation;
	public String date_change;
	public String unity_measurement_weight;
	public String unity_measurement_distance;
	public String currency_cost;
	public String status;
	public Map<String,CountryCosts_Model> countryCosts = new HashMap<String,CountryCosts_Model>();

}
