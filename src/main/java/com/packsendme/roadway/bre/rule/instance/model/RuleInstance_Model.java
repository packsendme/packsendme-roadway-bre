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

	public String rule_type_way;
	public Double distance_max;
	public Double weight_max;
	public boolean allow_cross_continent;

	// Percentage PackSendMe
	public Double percentage_reshipping;
	public Double percentage_rate_availability;

	// Standard by Country
	public String unity_measurement_weight;
	public String unity_measurement_distance;

	
	public RuleInstance_Model(String rule_type_way, Double distance_max, Double weight_max,
			boolean allow_cross_continent, Double percentage_reshipping, Double percentage_rate_availability,
			String unity_measurement_weight, String unity_measurement_distance) {
		super();
		this.rule_type_way = rule_type_way;
		this.distance_max = distance_max;
		this.weight_max = weight_max;
		this.allow_cross_continent = allow_cross_continent;
		this.percentage_reshipping = percentage_reshipping;
		this.percentage_rate_availability = percentage_rate_availability;
		this.unity_measurement_weight = unity_measurement_weight;
		this.unity_measurement_distance = unity_measurement_distance;
	}

	public RuleInstance_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
