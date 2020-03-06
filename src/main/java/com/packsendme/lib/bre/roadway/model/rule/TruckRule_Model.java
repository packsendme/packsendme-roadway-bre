package com.packsendme.lib.bre.roadway.model.rule;

import com.packsendme.lib.bre.roadway.model.costs.TruckCosts_Model;

public class TruckRule_Model {

	public int distance_max_truck;
	public int weight_max_truck;
	public int percentage_rate_availability_truck;
	public TruckCosts_Model truckCosts = new TruckCosts_Model();
	
	
	public int getDistance_max_truck() {
		return distance_max_truck;
	}
	public void setDistance_max_truck(int distance_max_truck) {
		this.distance_max_truck = distance_max_truck;
	}
	public int getWeight_max_truck() {
		return weight_max_truck;
	}
	public void setWeight_max_truck(int weight_max_truck) {
		this.weight_max_truck = weight_max_truck;
	}
	public int getPercentage_rate_availability_truck() {
		return percentage_rate_availability_truck;
	}
	public void setPercentage_rate_availability_truck(int percentage_rate_availability_truck) {
		this.percentage_rate_availability_truck = percentage_rate_availability_truck;
	}
	public TruckCosts_Model getTruckCosts() {
		return truckCosts;
	}
	public void setTruckCosts(TruckCosts_Model truckCosts) {
		this.truckCosts = truckCosts;
	}

	
	
	
}
