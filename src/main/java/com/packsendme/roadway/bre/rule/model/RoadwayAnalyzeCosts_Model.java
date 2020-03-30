package com.packsendme.roadway.bre.rule.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class RoadwayAnalyzeCosts_Model {
	
	public int id_rule;
	public Date date_creation;
	public String date_change;
	public String unity_measurement_weight;
	public String unity_measurement_distance;
	public String currency_cost;
	public String status;
	public Map<String,CostsBRE_Model> costsBRE = new HashMap<String,CostsBRE_Model>();

}
