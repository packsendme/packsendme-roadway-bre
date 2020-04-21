package com.packsendme.roadway.bre.rule.sa.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.roadway.bre.rule.costs.model.BicycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.CarCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.MotorcycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.RuleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.TruckCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.WalkCosts_Model;
import com.packsendme.roadway.bre.rule.instance.model.BicycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.CarInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.MotorcycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.RuleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.TruckInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.WalkingInstance_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
 public class RoadwayInstanceBRE_SA_Test {

	RoadwayBRE_Model roadwayBRE = new RoadwayBRE_Model();
	private String jsonSouthAmerica = null;
	private String url_json = "src/test/resources/RoadwayBRE_SA_V1.json";
	private String json_country_sa = "src/test/resources/Country_SA.txt";
	private final String name_rule = "Roadway-SouthAmerica-BRE";

	// Rule
	RuleInstance_Model ruleInstance = new RuleInstance_Model();
	BicycleInstance_Model bicycleInstance = new BicycleInstance_Model();
	CarInstance_Model carInstance = new CarInstance_Model();
	MotorcycleInstance_Model motorcycleInstance = new MotorcycleInstance_Model();
	TruckInstance_Model truckInstance = new TruckInstance_Model();
	WalkingInstance_Model walkingInstance = new WalkingInstance_Model();
	
	
	@Test
	void generateJsonSouthAmerica() throws URISyntaxException, IOException {
		
		// RoadwayModel
		roadwayBRE.name_rule = name_rule;
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
		carInstance.percentage_reshipping = 20.5;
		carInstance.percentage_rate_availability = 10.0;
		
		//Motorcycle_Model
		motorcycleInstance.distance_max_motorcycle = 10.2;
		motorcycleInstance.weight_max_motorcycle = 30.4;
		carInstance.percentage_reshipping = 20.5;
		carInstance.percentage_rate_availability = 10.0;
		
		//Truck_Model
		truckInstance.allow_cross_continent_truck = false;
		truckInstance.weight_max_truck = 30.2;
		carInstance.percentage_reshipping = 20.5;
		carInstance.percentage_rate_availability = 10.0;
		
		//Walking_Model
		walkingInstance.distance_max_walking = 10.3;
		walkingInstance.weight_max_walking = 30.2;
		carInstance.percentage_reshipping = 20.5;
		carInstance.percentage_rate_availability = 10.0;
		
		
		ruleInstance.bicycle = bicycleInstance;
		ruleInstance.car  = carInstance;
		ruleInstance.motorcycle = motorcycleInstance;
		ruleInstance.truck = truckInstance;
		ruleInstance.walking = walkingInstance;
		roadwayBRE.ruleInstance = ruleInstance;
				
		roadwayBRE = generateCosts(roadwayBRE);
			
		ObjectMapper mapper = new ObjectMapper();
		jsonSouthAmerica = mapper.writeValueAsString(roadwayBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		inputJsonFileSouthAmerica(jsonSouthAmerica);
	}
	
	RoadwayBRE_Model generateCosts(RoadwayBRE_Model roadwayBRE) {
		RuleCosts_Model ruleCosts = new RuleCosts_Model();
		//ArrayList<RuleCosts_Model> costsL = new ArrayList<RuleCosts_Model>();
		Map<String,RuleCosts_Model> costsL = new HashMap<String,RuleCosts_Model>();
		
		// Rule
		BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();
		CarCosts_Model carCosts = new CarCosts_Model();
		MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
		TruckCosts_Model truckCosts = new TruckCosts_Model();
		WalkCosts_Model walkingCosts = new WalkCosts_Model();

		
		List<String> countryL = getCountry();

		ArrayList<RuleCosts_Model> countryCostsL;
		for(String country : countryL) {
			
			// BicycleCosts_Model
			bicycleCosts.cost_weight_bicycle = 10.0;
			bicycleCosts.cost_distance_bicycle = 30.0;

			// CarCosts_Model
			carCosts.weight_cost = 0.50;
			carCosts.distance_cost = 1.0 ;
			carCosts.tolls_average_cost = 0.70;
			carCosts.fuel_average_cost = 0.40;
			carCosts.average_consumption_cost = 10.0;

			//Motorcycle_Model
			motorcycleCosts.weight_cost = 0.60;
			motorcycleCosts.distance_cost = 0.60;
			motorcycleCosts.tolls_average_cost = 0.60;
			motorcycleCosts.fuel_average_cost = 0.60;
			motorcycleCosts.average_consumption_cost = 10.0;

			//Truck_Model
			truckCosts.weight_cost = 0.20;
			truckCosts.distance_cost = 0.80;
			truckCosts.tolls_average_cost = 10.0;
			truckCosts.fuel_average_cost = 20.0;
			truckCosts.average_consumption_cost = 10.0;
			
			//Walking_Model
			walkingCosts.weight_cost = 2.40;
			walkingCosts.distance_cost = 50.0;
			
			// BRE
			ruleCosts.name_country = country;
			ruleCosts.bicycle = bicycleCosts;
			ruleCosts.car = carCosts;
			ruleCosts.motorcycle = motorcycleCosts;
			ruleCosts.truck = truckCosts;
			ruleCosts.walking = walkingCosts;
			//costsL.add(ruleCosts);
			costsL.put(country, ruleCosts);
			ruleCosts = new RuleCosts_Model();
		}

		roadwayBRE.ruleCosts = costsL;
		return roadwayBRE;
	}
	
	public List<String> getCountry() {
		List<String> countryL = new ArrayList<String>();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(json_country_sa));
			String line = reader.readLine();
			while(line != null) {
				System.out.println(line);
				countryL.add(line);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return countryL;
	}

	void inputJsonFileSouthAmerica(String jsonSouthAmerica) throws IOException, URISyntaxException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(url_json);
		if (file.length() != 0) {
			String absolutePath = file.getAbsolutePath();
			RoadwayBRE_Model obj = mapper.readValue(new File(absolutePath), RoadwayBRE_Model.class);
			Assert.notNull(obj);
		}
		else {
			try (FileWriter fileWriter = new FileWriter(url_json, true)) {
			    fileWriter.write(jsonSouthAmerica);
			}
		}
	}
}
