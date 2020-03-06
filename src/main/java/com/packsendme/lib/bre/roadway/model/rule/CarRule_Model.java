package com.packsendme.lib.bre.roadway.model.rule;

import com.packsendme.lib.bre.roadway.model.costs.CarCosts_Model;

public class CarRule_Model {
	
	public int distance_max_car;
	public int weight_max_car;
	public int percentage_rate_availability_car;
	public CarCosts_Model carCosts = new CarCosts_Model();
	
	public int getDistance_max_car() {
		return distance_max_car;
	}
	public void setDistance_max_car(int distance_max_car) {
		this.distance_max_car = distance_max_car;
	}
	public int getWeight_max_car() {
		return weight_max_car;
	}
	public void setWeight_max_car(int weight_max_car) {
		this.weight_max_car = weight_max_car;
	}
	public int getPercentage_rate_availability_car() {
		return percentage_rate_availability_car;
	}
	public void setPercentage_rate_availability_car(int percentage_rate_availability_car) {
		this.percentage_rate_availability_car = percentage_rate_availability_car;
	}
	public CarCosts_Model getCarCosts() {
		return carCosts;
	}
	public void setCarCosts(CarCosts_Model carCosts) {
		this.carCosts = carCosts;
	}


}
