package com.packsendme.lib.bre.roadway.model;

import java.util.Date;

import com.packsendme.lib.bre.roadway.model.rule.BicycleRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.CarRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.MotorcycleRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.TruckRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.WalkingRule_Model;

public class RoadwayBRE_Model {
	
	public String id_rule;
	public Date date_creation;
	public String date_change;
	public String status;
	
	public BicycleRule_Model bicycle = new BicycleRule_Model();
	public CarRule_Model car = new CarRule_Model();
	public MotorcycleRule_Model motorcycle = new MotorcycleRule_Model();
	public TruckRule_Model truck = new TruckRule_Model();
	public WalkingRule_Model walking = new WalkingRule_Model();
	
	public String getId_rule() {
		return id_rule;
	}
	public void setId_rule(String id_rule) {
		this.id_rule = id_rule;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public String getDate_change() {
		return date_change;
	}
	public void setDate_change(String date_change) {
		this.date_change = date_change;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BicycleRule_Model getBicycle() {
		return bicycle;
	}
	public void setBicycle(BicycleRule_Model bicycle) {
		this.bicycle = bicycle;
	}
	public CarRule_Model getCar() {
		return car;
	}
	public void setCar(CarRule_Model car) {
		this.car = car;
	}
	public MotorcycleRule_Model getMotorcycle() {
		return motorcycle;
	}
	public void setMotorcycle(MotorcycleRule_Model motorcycle) {
		this.motorcycle = motorcycle;
	}
	public TruckRule_Model getTruck() {
		return truck;
	}
	public void setTruck(TruckRule_Model truck) {
		this.truck = truck;
	}
	public WalkingRule_Model getWalking() {
		return walking;
	}
	public void setWalking(WalkingRule_Model walking) {
		this.walking = walking;
	}
	
}
