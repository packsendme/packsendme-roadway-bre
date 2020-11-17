package com.packsendme.roadway.bre.model.location;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Document(collection = "pcks_roadbrewa_location")
public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String codCountry;
	public String countryName;
	public boolean citySpecify;
	public List<String> cityName;
	
	
 

	public Location(String codCountry, String countryName, boolean citySpecify, List<String> cityName) {
		super();
		this.codCountry = codCountry;
		this.countryName = countryName;
		this.citySpecify = citySpecify;
		this.cityName = cityName;
	}




	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
