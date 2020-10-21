package com.packsendme.roadway.bre.model.businessrule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.packsendme.roadway.bre.model.category.Category;
import com.packsendme.roadway.bre.model.location.Location;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RoadwayBRE implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String id;
	public String name_bre;
	public String transport;
	public String date_creation;
	public String date_change;
	public List<Category> categories = new ArrayList<Category>();
	public List<RoadwayCosts> costs = new ArrayList<RoadwayCosts>();
	public List<Location> locations = new ArrayList<Location>();
	public String version;
	public String status;

	public RoadwayBRE(String name_bre, String transport, String date_creation, String date_change,
			List<Category> categories, List<RoadwayCosts> costs, List<Location> locations, String version,
			String status) {
		super();
		this.name_bre = name_bre;
		this.transport = transport;
		this.date_creation = date_creation;
		this.date_change = date_change;
		this.categories = categories;
		this.costs = costs;
		this.locations = locations;
		this.version = version;
		this.status = status;
	}

	public RoadwayBRE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
