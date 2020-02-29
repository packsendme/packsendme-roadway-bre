package com.packsendme.lib.bre.roadway.model;

import java.util.Date;

import com.packsendme.lib.bre.roadway.model.costs.BicycleCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.CarCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.MotorcycleCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.TruckCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.WalkingCosts_Model;

public class RoadwayBRE_Model {
	
	public String id_rule;
	public Date date_creation;
	public String date_change;
	public String status;
	
	public BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();
	public CarCosts_Model carCosts = new CarCosts_Model();
	public MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
	public TruckCosts_Model truckCosts = new TruckCosts_Model();
	public WalkingCosts_Model walkingCosts = new WalkingCosts_Model();
	
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
	public BicycleCosts_Model getBicycleCosts() {
		return bicycleCosts;
	}
	public void setBicycleCosts(BicycleCosts_Model bicycleCosts) {
		this.bicycleCosts = bicycleCosts;
	}
	public CarCosts_Model getCarCosts() {
		return carCosts;
	}
	public void setCarCosts(CarCosts_Model carCosts) {
		this.carCosts = carCosts;
	}
	public MotorcycleCosts_Model getMotorcycleCosts() {
		return motorcycleCosts;
	}
	public void setMotorcycleCosts(MotorcycleCosts_Model motorcycleCosts) {
		this.motorcycleCosts = motorcycleCosts;
	}
	public TruckCosts_Model getTruckCosts() {
		return truckCosts;
	}
	public void setTruckCosts(TruckCosts_Model truckCosts) {
		this.truckCosts = truckCosts;
	}
	public WalkingCosts_Model getWalkingCosts() {
		return walkingCosts;
	}
	public void setWalkingCosts(WalkingCosts_Model walkingCosts) {
		this.walkingCosts = walkingCosts;
	} 
	
	

}
