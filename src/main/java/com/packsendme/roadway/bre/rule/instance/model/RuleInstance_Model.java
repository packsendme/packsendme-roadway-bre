package com.packsendme.roadway.bre.rule.instance.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RuleInstance_Model implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String category;
	public String rule_type_way;
	public Double distance_max;
	public Double weight_max;
	public boolean allow_cross_continent;
	public int axis_amont;
	public int people_max;
	public int pbm_max;
	
	public Map<String, Integer> axis_distribution = new HashMap<String, Integer>();

	// Standard by Country
	public String unity_measurement_weight;
	public String unity_measurement_distance;

 
 

	public RuleInstance_Model(String category, String rule_type_way, Double distance_max, Double weight_max,
			boolean allow_cross_continent, int axis_amont, int people_max, int pbm_max,
			Map<String, Integer> axis_distribution, String unity_measurement_weight,
			String unity_measurement_distance) {
		super();
		this.category = category;
		this.rule_type_way = rule_type_way;
		this.distance_max = distance_max;
		this.weight_max = weight_max;
		this.allow_cross_continent = allow_cross_continent;
		this.axis_amont = axis_amont;
		this.people_max = people_max;
		this.pbm_max = pbm_max;
		this.axis_distribution = axis_distribution;
		this.unity_measurement_weight = unity_measurement_weight;
		this.unity_measurement_distance = unity_measurement_distance;
	}




	public RuleInstance_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
