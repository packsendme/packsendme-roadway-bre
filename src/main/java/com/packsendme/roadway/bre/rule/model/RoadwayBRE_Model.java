package com.packsendme.roadway.bre.rule.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.packsendme.roadway.bre.rule.costs.model.RuleCosts_Model;
import com.packsendme.roadway.bre.rule.instance.model.RuleInstance_Model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RoadwayBRE_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name_rule;
	public Date date_creation;
	public String date_change;
	public String unity_measurement_weight;
	public String unity_measurement_distance;
	public String currency_cost;
	public String status;
	
	public RuleInstance_Model ruleInstance = new RuleInstance_Model();
	//public ArrayList<RuleCosts_Model> ruleCosts = new ArrayList<RuleCosts_Model>();
	public Map<String, RuleCosts_Model> ruleCosts = new HashMap<String, RuleCosts_Model>();
}
