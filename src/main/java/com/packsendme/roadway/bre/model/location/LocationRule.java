package com.packsendme.roadway.bre.model.location;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class LocationRule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String countryName;
	public String cityName;
	public String stateName;
	public String codCountry;
	
	
	public LocationRule(String countryName, String cityName, String stateName, String codCountry) {
		super();
		this.countryName = countryName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.codCountry = codCountry;
	}


	public LocationRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
