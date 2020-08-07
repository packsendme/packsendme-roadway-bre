package com.packsendme.roadway.bre.model.businessrule;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RoadwayBRE implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String rule_name;
	public String date_creation;
	public String date_change;
	public String status;
	public CategoryBRE category;


	public RoadwayBRE(String rule_name, String date_creation, String date_change, String status,CategoryBRE category) {
		super();
		this.rule_name = rule_name;
		this.date_creation = date_creation;
		this.date_change = date_change;
		this.status = status;
		this.category = category;
	}

	public RoadwayBRE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
