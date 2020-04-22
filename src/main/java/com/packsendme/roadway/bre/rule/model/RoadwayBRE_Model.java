package com.packsendme.roadway.bre.rule.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	public String status;
	
	public Map<String, RuleInstance_Model> ruleInstance = new HashMap<String, RuleInstance_Model>();
	public Map<String,Map> ruleCosts = new HashMap<String, Map>();
}
