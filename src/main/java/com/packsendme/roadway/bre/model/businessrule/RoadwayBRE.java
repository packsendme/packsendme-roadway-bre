package com.packsendme.roadway.bre.model.businessrule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RoadwayBRE implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String type_bre;
	public String date_creation;
	public String date_change;
	public List<CategoryBRE> categories = new ArrayList<CategoryBRE>();
	public String status;

	public RoadwayBRE(String type_bre, String date_creation, String date_change, List<CategoryBRE> categories,
			String status) {
		super();
		this.type_bre = type_bre;
		this.date_creation = date_creation;
		this.date_change = date_change;
		this.categories = categories;
		this.status = status;
	}



	public RoadwayBRE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
