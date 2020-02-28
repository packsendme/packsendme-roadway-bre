package com.packsendme.lib.bre.roadway.model;

import java.util.Date;

import com.packsendme.lib.bre.roadway.model.costs.BicycleCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.CarCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.MotorcycleCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.TruckCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.WalkingCostsModel;

public class RoadwayModel {
	
	public String id_rule;
	public Date date_creation;
	public String date_change;
	public String status;
	
	public BicycleCostsModel bicycleCosts = new BicycleCostsModel();
	public CarCostsModel carCosts = new CarCostsModel();
	public MotorcycleCostsModel motorcycleCosts = new MotorcycleCostsModel();
	public TruckCostsModel truckCosts = new TruckCostsModel();
	public WalkingCostsModel walkingCosts = new WalkingCostsModel();
	
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
	public BicycleCostsModel getBicycleCosts() {
		return bicycleCosts;
	}
	public void setBicycleCosts(BicycleCostsModel bicycleCosts) {
		this.bicycleCosts = bicycleCosts;
	}
	public CarCostsModel getCarCosts() {
		return carCosts;
	}
	public void setCarCosts(CarCostsModel carCosts) {
		this.carCosts = carCosts;
	}
	public MotorcycleCostsModel getMotorcycleCosts() {
		return motorcycleCosts;
	}
	public void setMotorcycleCosts(MotorcycleCostsModel motorcycleCosts) {
		this.motorcycleCosts = motorcycleCosts;
	}
	public TruckCostsModel getTruckCosts() {
		return truckCosts;
	}
	public void setTruckCosts(TruckCostsModel truckCosts) {
		this.truckCosts = truckCosts;
	}
	public WalkingCostsModel getWalkingCosts() {
		return walkingCosts;
	}
	public void setWalkingCosts(WalkingCostsModel walkingCosts) {
		this.walkingCosts = walkingCosts;
	} 
	
	

}
