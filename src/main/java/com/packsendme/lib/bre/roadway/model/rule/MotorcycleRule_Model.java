package com.packsendme.lib.bre.roadway.model.rule;

import com.packsendme.lib.bre.roadway.model.costs.MotorcycleCosts_Model;

public class MotorcycleRule_Model {
	
	public int distance_max_motorcycle;
	public int weight_max_motorcycle;
	public int percentage_rate_availability_motorcycle;
	public MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
	
	
	public int getDistance_max_motorcycle() {
		return distance_max_motorcycle;
	}
	public void setDistance_max_motorcycle(int distance_max_motorcycle) {
		this.distance_max_motorcycle = distance_max_motorcycle;
	}
	public int getWeight_max_motorcycle() {
		return weight_max_motorcycle;
	}
	public void setWeight_max_motorcycle(int weight_max_motorcycle) {
		this.weight_max_motorcycle = weight_max_motorcycle;
	}
	public int getPercentage_rate_availability_motorcycle() {
		return percentage_rate_availability_motorcycle;
	}
	public void setPercentage_rate_availability_motorcycle(int percentage_rate_availability_motorcycle) {
		this.percentage_rate_availability_motorcycle = percentage_rate_availability_motorcycle;
	}
	public MotorcycleCosts_Model getMotorcycleCosts() {
		return motorcycleCosts;
	}
	public void setMotorcycleCosts(MotorcycleCosts_Model motorcycleCosts) {
		this.motorcycleCosts = motorcycleCosts;
	}

	
}
