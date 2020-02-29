package com.packsendme.lib.bre.roadway.model.costs;

public class CarCosts_Model {
	
	public Double cost_distance_car;
	public Double cost_variable_car;
	public Double percentage_reshipping_car;
	public Double percentage_storage_car;
	public Double percentage_cubage_car;
	
	
	public Double getCost_variable_car() {
		return cost_variable_car;
	}
	public void setCost_distance_car(Double cost_distance_car) {
		this.cost_distance_car = cost_distance_car;
	}
	
	public void setCost_variable_car(Double cost_variable_car) {
		this.cost_variable_car = cost_variable_car;
	}
	public Double getCost_distance_car() {
		return cost_distance_car;
	}
	public Double getPercentage_reshipping_car() {
		return percentage_reshipping_car;
	}
	public void setPercentage_reshipping_car(Double percentage_reshipping_car) {
		this.percentage_reshipping_car = percentage_reshipping_car;
	}
	public Double getPercentage_storage_car() {
		return percentage_storage_car;
	}
	public void setPercentage_storage_car(Double percentage_storage_car) {
		this.percentage_storage_car = percentage_storage_car;
	}
	public Double getPercentage_cubage_car() {
		return percentage_cubage_car;
	}
	public void setPercentage_cubage_car(Double percentage_cubage_car) {
		this.percentage_cubage_car = percentage_cubage_car;
	}
	
}
