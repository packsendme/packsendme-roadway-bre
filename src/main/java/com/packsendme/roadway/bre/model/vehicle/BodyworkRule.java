package com.packsendme.roadway.bre.model.vehicle;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Document(collection = "pcks_roadbrewa_bodywork")
public class BodyworkRule  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String bodyWork;
	public String type;
	

}
