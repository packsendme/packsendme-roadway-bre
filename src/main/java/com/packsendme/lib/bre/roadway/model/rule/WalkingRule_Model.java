package com.packsendme.lib.bre.roadway.model.rule;

import com.packsendme.lib.bre.roadway.model.costs.WalkingCosts_Model;

public class WalkingRule_Model {
	
	public int distance_max_walking;
	public int weight_max_walking;
	public int percentage_rate_availability_walking;
	public WalkingCosts_Model walkingCosts = new WalkingCosts_Model();
	
	
	public int getDistance_max_walking() {
		return distance_max_walking;
	}
	public void setDistance_max_walking(int distance_max_walking) {
		this.distance_max_walking = distance_max_walking;
	}
	public int getWeight_max_walking() {
		return weight_max_walking;
	}
	public void setWeight_max_walking(int weight_max_walking) {
		this.weight_max_walking = weight_max_walking;
	}
	public int getPercentage_rate_availability_walking() {
		return percentage_rate_availability_walking;
	}
	public void setPercentage_rate_availability_walking(int percentage_rate_availability_walking) {
		this.percentage_rate_availability_walking = percentage_rate_availability_walking;
	}
	public WalkingCosts_Model getWalkingCosts() {
		return walkingCosts;
	}
	public void setWalkingCosts(WalkingCosts_Model walkingCosts) {
		this.walkingCosts = walkingCosts;
	}

	
}
