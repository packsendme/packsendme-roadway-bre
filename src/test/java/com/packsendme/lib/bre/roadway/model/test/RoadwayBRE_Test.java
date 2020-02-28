package com.packsendme.lib.bre.roadway.model.test;



import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.bre.roadway.model.RoadwayModel;
import com.packsendme.lib.bre.roadway.model.costs.BicycleCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.CarCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.MotorcycleCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.TruckCostsModel;
import com.packsendme.lib.bre.roadway.model.costs.WalkingCostsModel;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
 public class RoadwayBRE_Test {

	 RoadwayModel roadwayBRE = new RoadwayModel();

	BicycleCostsModel bicycleModel = new BicycleCostsModel();
	CarCostsModel carModel = new CarCostsModel();
	MotorcycleCostsModel motorcycleModel = new MotorcycleCostsModel();
	TruckCostsModel truckModel = new TruckCostsModel();
	WalkingCostsModel walkingModel = new WalkingCostsModel();

	
	@Test
	void generateJsonSouthAmerica() throws JsonProcessingException {
		// RoadwayModel
		roadwayBRE.id_rule = "0010101";
		roadwayBRE.date_creation = new Date();
		roadwayBRE.date_change = null;
		roadwayBRE.status = "Active";
		
		// BicycleModel
		bicycleModel.cost_distance_bicycle = 1.0;
		bicycleModel.cost_variable_bicycle = 0.50;
		bicycleModel.percentage_reshipping_bicycle = 30.0;
		bicycleModel.percentage_storage_bicycle = 10.0;

		// CarCostsModel
		carModel.cost_distance_car = 1.5;
		carModel.cost_variable_car = 2.5;
		carModel.percentage_reshipping_car = 2.0;
		carModel.percentage_storage_car = 3.2;
		carModel.percentage_cubage_car = 4.1;
		
		//MotorcycleCostsModel
		motorcycleModel.cost_distance_motorcycle = 4.0;
		motorcycleModel.cost_variable_motorcycle = 2.3;
		motorcycleModel.percentage_reshipping_motorcycle = 0.5;
		motorcycleModel.percentage_storage_motorcycle = 1.0;
		
		//TruckCostsModel
		truckModel.cost_distance_truck = 1.0;
		truckModel.cost_variable_truck = 0.6;
		truckModel.percentage_reshipping_truck = 2.0;
		truckModel.percentage_storage_truck = 1.5;
		truckModel.percentage_cubage_truck = 5.0;
		
		//WalkingCostsModel
		walkingModel.cost_distance_walking = 1.0;
		walkingModel.cost_variable_walking = 1.0;
		walkingModel.percentage_reshipping_walking = 1.5;
		walkingModel.percentage_storage_walking = 1.5;
		
		roadwayBRE.bicycleCosts = bicycleModel;
		roadwayBRE.carCosts = carModel;
		roadwayBRE.motorcycleCosts = motorcycleModel;
		roadwayBRE.truckCosts = truckModel;
		roadwayBRE.walkingCosts = walkingModel;
			
		ObjectMapper mapper = new ObjectMapper();
		String jsonSouthAmerica = mapper.writeValueAsString(roadwayBRE);
		
		System.out.println(jsonSouthAmerica);
		Assert.notNull(jsonSouthAmerica);
	}

	@Test
	void inputJsonFileSouthAmerica() throws IOException, URISyntaxException {
		ObjectMapper mapper = new ObjectMapper();
		URL res = getClass().getClassLoader().getResource("roadwayBRE_v1.json");
		File file = Paths.get(res.toURI()).toFile();
		String absolutePath = file.getAbsolutePath();
		RoadwayModel obj = null;
		obj = mapper.readValue(new File(absolutePath), RoadwayModel.class);
	} 
}
