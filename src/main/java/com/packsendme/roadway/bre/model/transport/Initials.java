package com.packsendme.roadway.bre.model.transport;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
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
	

	
}
