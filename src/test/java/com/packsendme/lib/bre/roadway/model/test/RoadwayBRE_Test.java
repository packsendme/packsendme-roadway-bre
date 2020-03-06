package com.packsendme.lib.bre.roadway.model.test;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.bre.roadway.model.RoadwayBRE_Model;
import com.packsendme.lib.bre.roadway.model.costs.BicycleCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.CarCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.MotorcycleCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.TruckCosts_Model;
import com.packsendme.lib.bre.roadway.model.costs.WalkingCosts_Model;
import com.packsendme.lib.bre.roadway.model.rule.BicycleRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.CarRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.MotorcycleRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.TruckRule_Model;
import com.packsendme.lib.bre.roadway.model.rule.WalkingRule_Model;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
 public class RoadwayBRE_Test {

	RoadwayBRE_Model roadwayBRE = new RoadwayBRE_Model();

	// Rule
	BicycleRule_Model bicycleRule = new BicycleRule_Model();
	CarRule_Model carRule = new CarRule_Model();
	MotorcycleRule_Model motorcycleRule = new MotorcycleRule_Model();
	TruckRule_Model truckRule = new TruckRule_Model();
	WalkingRule_Model walkingRule = new WalkingRule_Model();

	
	// Costs
	BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();
	CarCosts_Model carCosts = new CarCosts_Model();
	MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
	TruckCosts_Model truckCosts = new TruckCosts_Model();
	WalkingCosts_Model walkingCosts = new WalkingCosts_Model();

	
	@Test
	void generateJsonSouthAmerica() throws JsonProcessingException {
		// RoadwayModel
		roadwayBRE.id_rule = "0010101";
		roadwayBRE.date_creation = new Date();
		roadwayBRE.date_change = null;
		roadwayBRE.status = "Active";
		
		// BicycleModel
		bicycleRule.distance_max_bicycle = 10;
		bicycleRule.weight_max_bicycle = 30;
		bicycleRule.percentage_rate_availability_bicycle = 20;
		
		bicycleCosts.cost_distance_bicycle = 1.0;
		bicycleCosts.cost_variable_bicycle = 0.50;
		bicycleCosts.percentage_reshipping_bicycle = 30.0;
		bicycleCosts.percentage_storage_bicycle = 10.0;
		bicycleCosts.percentage_rate_availability = 10.0;
		bicycleRule.bicycleCosts = bicycleCosts; 
		
		// CarCostsModel
		carRule.distance_max_car = 10;
		carRule.weight_max_car = 30;
		carRule.percentage_rate_availability_car = 20;
		
		carCosts.cost_distance_car = 1.5;
		carCosts.cost_variable_car = 2.5;
		carCosts.percentage_reshipping_car = 2.0;
		carCosts.percentage_storage_car = 3.2;
		carCosts.percentage_cubage_car = 4.1;
		carCosts.percentage_rate_availability = 10.0;
		carRule.carCosts = carCosts; 

		//MotorcycleCostsModel
		motorcycleRule.distance_max_motorcycle = 10;
		motorcycleRule.weight_max_motorcycle = 30;
		motorcycleRule.percentage_rate_availability_motorcycle = 20;
		
		motorcycleCosts.cost_distance_motorcycle = 4.0;
		motorcycleCosts.cost_variable_motorcycle = 2.3;
		motorcycleCosts.percentage_reshipping_motorcycle = 0.5;
		motorcycleCosts.percentage_storage_motorcycle = 1.0;
		motorcycleCosts.percentage_rate_availability = 10.0;
		motorcycleRule.motorcycleCosts = motorcycleCosts; 

		//TruckCostsModel
		truckRule.distance_max_truck = 10;
		truckRule.weight_max_truck = 30;
		truckRule.percentage_rate_availability_truck = 20;
		
		truckCosts.cost_distance_truck = 1.0;
		truckCosts.cost_variable_truck = 0.6;
		truckCosts.percentage_reshipping_truck = 2.0;
		truckCosts.percentage_storage_truck = 1.5;
		truckCosts.percentage_cubage_truck = 5.0;
		truckCosts.percentage_rate_availability = 10.0;
		truckRule.truckCosts = truckCosts; 

		
		//WalkingCostsModel
		walkingRule.distance_max_walking = 10;
		walkingRule.weight_max_walking = 30;
		walkingRule.percentage_rate_availability_walking = 20;
		
		walkingCosts.cost_distance_walking = 1.0;
		walkingCosts.cost_variable_walking = 1.0;
		walkingCosts.percentage_reshipping_walking = 1.5;
		walkingCosts.percentage_storage_walking = 1.5;
		walkingCosts.percentage_rate_availability = 10.0;
		walkingRule.walkingCosts = walkingCosts; 

		
		roadwayBRE.bicycle = bicycleRule;
		roadwayBRE.car  = carRule;
		roadwayBRE.motorcycle = motorcycleRule;
		roadwayBRE.truck = truckRule;
		roadwayBRE.walking = walkingRule;
			
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
		RoadwayBRE_Model obj = null;
		obj = mapper.readValue(new File(absolutePath), RoadwayBRE_Model.class);
	}
}
