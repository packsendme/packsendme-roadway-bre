package com.packsendme.lib.bre.roadway.model.rule;

import com.packsendme.lib.bre.roadway.model.costs.BicycleCosts_Model;

public class BicycleRule_Model {
	
	public int distance_max_bicycle;
	public int weight_max_bicycle;
	public int percentage_rate_availability_bicycle;
	public BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();

	public int getDistance_max_bicycle() {
		return distance_max_bicycle;
	}

	public void setDistance_max_bicycle(int distance_max_bicycle) {
		this.distance_max_bicycle = distance_max_bicycle;
	}

	public int getWeight_max_bicycle() {
		return weight_max_bicycle;
	}

	public void setWeight_max_bicycle(int weight_max_bicycle) {
		this.weight_max_bicycle = weight_max_bicycle;
	}

	public int getPercentage_rate_availability_bicycle() {
		return percentage_rate_availability_bicycle;
	}

	public void setPercentage_rate_availability_bicycle(int percentage_rate_availability_bicycle) {
		this.percentage_rate_availability_bicycle = percentage_rate_availability_bicycle;
	}

	public BicycleCosts_Model getBicycleCosts() {
		return bicycleCosts;
	}

	public void setBicycleCosts(BicycleCosts_Model bicycleCosts) {
		this.bicycleCosts = bicycleCosts;
	}

	
	

}
