package com.packsendme.roadway.bre.rule.sa.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.roadway.bre.rule.costs.model.BicycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.CarCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.CountryCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.MotorcycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.TruckCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.WalkCosts_Model;
import com.packsendme.roadway.bre.rule.instance.model.BicycleInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.CarInstance_Model;
import com.packsendme.roadway.bre.rule.instance.model.MotorcycleInstance_Model;
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
	BicycleInstance_Model bicycleInstance = new BicycleInstance_Model();
	CarInstance_Model carInstance = new CarInstance_Model();
	MotorcycleInstance_Model motorcycleInstance = new MotorcycleInstance_Model();
	TruckInstance_Model truckInstance = new TruckInstance_Model();
	WalkingInstance_Model walkingInstance = new WalkingInstance_Model();
	
	// Rule
	BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();
	CarCosts_Model carCosts = new CarCosts_Model();
	MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
	TruckCosts_Model truckCosts = new TruckCosts_Model();
	WalkCosts_Model walkingCosts = new WalkCosts_Model();
	
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
		
		roadwayBRE = generateCosts(roadwayBRE);
			
		ObjectMapper mapper = new ObjectMapper();
		jsonSouthAmerica = mapper.writeValueAsString(roadwayBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		inputJsonFileSouthAmerica(jsonSouthAmerica);
	}
	
	RoadwayBRE_Model generateCosts(RoadwayBRE_Model roadwayBRE) {
		CountryCosts_Model costsBRE = new CountryCosts_Model();
		ArrayList<CountryCosts_Model> countryCostsL = new ArrayList<CountryCosts_Model>();
		
		List<String> countryL = getCountry();

		for(String country : countryL) {
			
			// BicycleCosts_Model
			bicycleCosts.cost_weight_bicycle = 10.0;
			bicycleCosts.cost_distance_bicycle = 30.0;
			bicycleCosts.percentage_reshipping_bicycle = 20.0;
			bicycleCosts.percentage_rate_availability = 20.0;

			// CarCosts_Model
			carCosts.weight_cost = 0.50;
			carCosts.distance_cost = 1.0 ;
			carCosts.tolls_average_cost = 0.70;
			carCosts.fuel_average_cost = 0.40;
			carCosts.percentage_reshipping_bicycle = 0.40;
			carCosts.percentage_rate_availability = 10.0;

			//Motorcycle_Model
			motorcycleCosts.weight_cost = 0.60;
			motorcycleCosts.distance_cost = 0.60;
			motorcycleCosts.tolls_average_cost = 0.60;
			motorcycleCosts.fuel_average_cost = 0.60;
			motorcycleCosts.percentage_reshipping_bicycle = 0.60;
			motorcycleCosts.percentage_rate_availability = 0.60;

			//Truck_Model
			truckCosts.weight_cost = 0.20;
			truckCosts.distance_cost = 0.80;
			truckCosts.tolls_average_cost = 10.0;
			truckCosts.fuel_average_cost = 20.0;
			truckCosts.percentage_reshipping_bicycle = 12.5;
			truckCosts.percentage_rate_availability = 0.40;
			
			//Walking_Model
			walkingCosts.weight_cost = 2.40;
			walkingCosts.distance_cost = 50.0;
			walkingCosts.percentage_reshipping_bicycle = 1.20;
			walkingCosts.percentage_rate_availability = 20.1;
			
			// BRE
			costsBRE.name_country = country;
			costsBRE.bicycle = bicycleCosts;
			costsBRE.car = carCosts;
			costsBRE.motorcycle = motorcycleCosts;
			costsBRE.truck = truckCosts;
			costsBRE.walking = walkingCosts;
			countryCostsL.add(costsBRE);
			costsBRE = new CountryCosts_Model();
			System.out.println("Country  "+ costsBRE.name_country);
			System.out.println("Size  "+ countryCostsL.size());

		}

		roadwayBRE.costsCountry = countryCostsL;
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
