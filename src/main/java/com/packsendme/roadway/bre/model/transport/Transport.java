package com.packsendme.roadway.bre.model.transport;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class Transport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name_transport;
	public String initials;

	
	public Transport(String name_transport,String initials) {
		super();
		this.name_transport = name_transport;
		this.initials = initials;
	}


	public Transport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
