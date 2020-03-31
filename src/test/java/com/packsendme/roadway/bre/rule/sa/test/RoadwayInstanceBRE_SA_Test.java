package com.packsendme.roadway.bre.rule.sa.test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.roadway.bre.rule.instance.model.BicycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.CarInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.MotorcycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.TruckInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.WalkingInstance_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayInstanceBRE_Model;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
 public class RoadwayInstanceBRE_SA_Test {

	RoadwayInstanceBRE_Model roadwayBRE = new RoadwayInstanceBRE_Model();
	private String jsonSouthAmerica = null;
	private String url_json = "src/test/resources/roadwayBRE_sa_v1.json";
	
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
		
		// BicycleInstance_Model
		bicycleInstance.distance_max_bicycle = 10.0;
		bicycleInstance.weight_max_bicycle = 30.0;
		bicycleInstance.percentage_rate_availability_bicycle = 20.0;
		
		// CarInstance_Model
		carInstance.distance_max_car = 10.0;
		carInstance.weight_max_car = 30.0;
		carInstance.percentage_rate_availability_car = 20.5;

		//Motorcycle_Model
		motorcycleInstance.distance_max_motorcycle = 10.2;
		motorcycleInstance.weight_max_motorcycle = 30.4;
		motorcycleInstance.percentage_rate_availability_motorcycle = 20.3;
		
		//Truck_Model
		truckInstance.allow_cross_continent_truck = false;
		truckInstance.weight_max_truck = 30.2;
		truckInstance.percentage_rate_availability_truck = 20.5;
		
		//Walking_Model
		walkingInstance.distance_max_walking = 10.3;
		walkingInstance.weight_max_walking = 30.2;
		walkingInstance.percentage_rate_availability_walking = 20.4;
		
		
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
		File file = new File(url_json);
		if (file.length() != 0) {
			String absolutePath = file.getAbsolutePath();
			RoadwayInstanceBRE_Model obj = mapper.readValue(new File(absolutePath), RoadwayInstanceBRE_Model.class);
			Assert.notNull(obj);
		}
		else {
			try (FileWriter fileWriter = new FileWriter(url_json, true)) {
			    fileWriter.write(jsonSouthAmerica);
			}
		}
	}
}
