package com.packsendme.roadway.bre.rule.test;
import java.io.BufferedReader;
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
import com.packsendme.roadway.bre.rule.costs.model.MotorcycleCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.TruckCosts_Model;
import com.packsendme.roadway.bre.rule.costs.model.WalkCosts_Model;
import com.packsendme.roadway.bre.rule.model.CostsBRE_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayAnalyzeCosts_Model;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
 public class RoadwayCostsBRE_SA_Test {

	private String jsonSouthAmerica = null;
	private String url_json = "src/test/resources/Country_SA.txt";
	private String url_roadwaycosts_json = "src/test/resources/roadway_costs_v1.json";

	
	// Rule
	BicycleCosts_Model bicycleCosts = new BicycleCosts_Model();
	CarCosts_Model carCosts = new CarCosts_Model();
	MotorcycleCosts_Model motorcycleCosts = new MotorcycleCosts_Model();
	TruckCosts_Model truckCosts = new TruckCosts_Model();
	WalkCosts_Model walkingCosts = new WalkCosts_Model();

	
	@Test
	void generateJsonSouthAmerica() throws URISyntaxException, IOException {
		CostsBRE_Model costsBRE = new CostsBRE_Model();
		RoadwayAnalyzeCosts_Model roadwayAnalyzeCosts = new RoadwayAnalyzeCosts_Model();

		//Map<String,CostsBRE_Model> costsBRE = new HashMap<String,CostsBRE_Model>();
		List<String> countryL = getCountry();
		
		for(String country : countryL) {
			
			// RoadwayModel
			roadwayAnalyzeCosts.id_rule = 001;
			roadwayAnalyzeCosts.date_creation = new Date();
			roadwayAnalyzeCosts.date_change = null;
			roadwayAnalyzeCosts.status = "Active";
			roadwayAnalyzeCosts.unity_measurement_weight = "KG";
			roadwayAnalyzeCosts.unity_measurement_distance = "KM";
			roadwayAnalyzeCosts.currency_cost = "R$";
						
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
			costsBRE.bicycle = bicycleCosts;
			costsBRE.car = carCosts;
			costsBRE.motorcycle = motorcycleCosts;
			costsBRE.truck = truckCosts;
			costsBRE.walking = walkingCosts;
			
			roadwayAnalyzeCosts.costsBRE.put(country, costsBRE);
		}		
		
		ObjectMapper mapper = new ObjectMapper();
		jsonSouthAmerica = mapper.writeValueAsString(roadwayAnalyzeCosts);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		inputJsonFileSouthAmerica(jsonSouthAmerica);
	}
	
	public List<String> getCountry() {
		List<String> countryL = new ArrayList<String>();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(url_json));
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
		try (FileWriter fileWriter = new FileWriter(url_roadwaycosts_json, true)) {
		    fileWriter.write(jsonSouthAmerica);
		}
	}
	
}
