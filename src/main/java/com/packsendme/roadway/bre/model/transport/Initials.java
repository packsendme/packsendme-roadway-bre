package com.packsendme.roadway.bre.model.transport;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Document(collection = "pcks_roadbrewa_initials")
public class Initials implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name;

	public Initials(String name) {
		super();
		this.name = name;
	}

	public Initials() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
