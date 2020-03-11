package com.packsendme.bre.lib.roadway.model.test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.bre.lib.roadway.model.RoadwayBRE_Model;
import com.packsendme.bre.lib.roadway.rule.instance.model.BicycleInstance_Model;
import com.packsendme.bre.lib.roadway.rule.instance.model.CarInstance_Model;
import com.packsendme.bre.lib.roadway.rule.instance.model.MotorcycleInstance_Model;
import com.packsendme.bre.lib.roadway.rule.instance.model.TruckInstance_Model;
import com.packsendme.bre.lib.roadway.rule.instance.model.WalkingInstance_Model;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
 public class RoadwayBRE_Test {

	RoadwayBRE_Model roadwayBRE = new RoadwayBRE_Model();
	private String jsonSouthAmerica = null;

	
	// Rule
	BicycleInstance_Model bicycleInstance = new BicycleInstance_Model();
	CarInstance_Model carInstance = new CarInstance_Model();
	MotorcycleInstance_Model motorcycleInstance = new MotorcycleInstance_Model();
	TruckInstance_Model truckInstance = new TruckInstance_Model();
	WalkingInstance_Model walkingInstance = new WalkingInstance_Model();

	
	@Test
	void generateJsonSouthAmerica() throws URISyntaxException, IOException {
		// RoadwayModel
		roadwayBRE.id_rule = "0010101";
		roadwayBRE.date_creation = new Date();
		roadwayBRE.date_change = null;
		roadwayBRE.status = "Active";
		roadwayBRE.unity_measurement_weight = "KG";
		roadwayBRE.unity_measurement_distance = "KM";
		roadwayBRE.currency_cost = "R$";
		
		// BicycleModel
		bicycleInstance.distance_max_bicycle = 10.0;
		bicycleInstance.weight_max_bicycle = 30.0;
		bicycleInstance.percentage_rate_availability_bicycle = 20.0;
		
		bicycleInstance.bicycleCosts.cost_weight_bicycle = 0.30;
		bicycleInstance.bicycleCosts.cost_distance_bicycle = 1.0;
		bicycleInstance.bicycleCosts.cost_variable_bicycle = 0.50;
		bicycleInstance.bicycleCosts.percentage_reshipping_bicycle = 30.0;
		bicycleInstance.bicycleCosts.percentage_storage_bicycle = 10.0;
		bicycleInstance.bicycleCosts.percentage_rate_availability = 10.0;
		
		// CarCostsModel
		carInstance.distance_max_car = 10.0;
		carInstance.weight_max_car = 30.0;
		carInstance.percentage_rate_availability_car = 20.5;

		carInstance.carCosts.cost_weight_car = 0.30;
		carInstance.carCosts.cost_distance_car = 1.5;
		carInstance.carCosts.cost_variable_car = 2.5;
		carInstance.carCosts.percentage_reshipping_car = 2.0;
		carInstance.carCosts.percentage_storage_car = 3.2;
		carInstance.carCosts.percentage_rate_availability = 10.0;

		//MotorcycleCostsModel
		motorcycleInstance.distance_max_motorcycle = 10.2;
		motorcycleInstance.weight_max_motorcycle = 30.4;
		motorcycleInstance.percentage_rate_availability_motorcycle = 20.3;
		
		motorcycleInstance.motorcycleCosts.cost_weight_motorcycle = 0.30;
		motorcycleInstance.motorcycleCosts.cost_distance_motorcycle = 4.0;
		motorcycleInstance.motorcycleCosts.cost_variable_motorcycle = 2.3;
		motorcycleInstance.motorcycleCosts.percentage_reshipping_motorcycle = 0.5;
		motorcycleInstance.motorcycleCosts.percentage_storage_motorcycle = 1.0;
		motorcycleInstance.motorcycleCosts.percentage_rate_availability = 10.0;

		//TruckCostsModel
		truckInstance.allow_cross_continent_truck = false;
		truckInstance.weight_max_truck = 30.2;
		truckInstance.percentage_rate_availability_truck = 20.5;
		
		truckInstance.truckCosts.cost_weight_truck = 0.30;
		truckInstance.truckCosts.cost_distance_truck = 1.0;
		truckInstance.truckCosts.cost_variable_truck = 0.6;
		truckInstance.truckCosts.percentage_reshipping_truck = 2.0;
		truckInstance.truckCosts.percentage_storage_truck = 1.5;
		truckInstance.truckCosts.percentage_rate_availability = 10.0;
		
		//WalkingCostsModel
		walkingInstance.distance_max_walking = 10.3;
		walkingInstance.weight_max_walking = 30.2;
		walkingInstance.percentage_rate_availability_walking = 20.4;
		
		walkingInstance.walkingCosts.cost_weight_walk = 0.30;
		walkingInstance.walkingCosts.cost_weight_walk = 5.0;
		walkingInstance.walkingCosts.cost_distance_walk = 0.50;
		walkingInstance.walkingCosts.cost_variable_walk = 1.0;
		walkingInstance.walkingCosts.percentage_reshipping_walk = 1.5;
		walkingInstance.walkingCosts.percentage_storage_walk = 1.5;
		walkingInstance.walkingCosts.percentage_rate_availability = 10.0;

		roadwayBRE.bicycle = bicycleInstance;
		roadwayBRE.car  = carInstance;
		roadwayBRE.motorcycle = motorcycleInstance;
		roadwayBRE.truck = truckInstance;
		roadwayBRE.walking = walkingInstance;
			
		ObjectMapper mapper = new ObjectMapper();
		jsonSouthAmerica = mapper.writeValueAsString(roadwayBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		inputJsonFileSouthAmerica(jsonSouthAmerica);
	}
	

	void inputJsonFileSouthAmerica(String jsonSouthAmerica) throws IOException, URISyntaxException {
		ObjectMapper mapper = new ObjectMapper();
		URL res = getClass().getClassLoader().getResource("roadwayBRE_v1.json");
		File file = Paths.get(res.toURI()).toFile();
		if (file.length() != 0) {
			String absolutePath = file.getAbsolutePath();
			RoadwayBRE_Model obj = mapper.readValue(new File(absolutePath), RoadwayBRE_Model.class);
		}
		else {
			try (FileWriter fileWriter = new FileWriter("src/test/java/roadwayBRE_v1.json", true)) {
			    fileWriter.write(jsonSouthAmerica);
			}
		}
	}
}
