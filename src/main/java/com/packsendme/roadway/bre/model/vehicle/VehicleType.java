package com.packsendme.roadway.bre.model.vehicle;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Document(collection = "pcks_roadbrewa_vehicletype")
public class VehicleType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String type_vehicle;
}
