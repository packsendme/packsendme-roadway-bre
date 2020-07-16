package com.packsendme.roadway.bre.model.businessrule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.packsendme.roadway.bre.model.vehicle.VehicleBRE;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class BusinessRuleRoadwayBRE implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String rule_name;
	public String category_name;
	public String date_creation;
	public String date_change;
	public String status;
	
	public List<VehicleBRE> vehicleInstance = new ArrayList<VehicleBRE>();
	public Map<String,Map<String, VehicleCostsBRE>> vehicleCosts = new HashMap<String, Map<String, VehicleCostsBRE>>();
	
	
	public BusinessRuleRoadwayBRE(String rule_name, String category_name, String date_creation, String date_change,
			String status, List<VehicleBRE> vehicleInstance,
			Map<String, Map<String, VehicleCostsBRE>> vehicleCosts) {
		super();
		this.rule_name = rule_name;
		this.category_name = category_name;
		this.date_creation = date_creation;
		this.date_change = date_change;
		this.status = status;
		this.vehicleInstance = vehicleInstance;
		this.vehicleCosts = vehicleCosts;
	}


	public BusinessRuleRoadwayBRE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
