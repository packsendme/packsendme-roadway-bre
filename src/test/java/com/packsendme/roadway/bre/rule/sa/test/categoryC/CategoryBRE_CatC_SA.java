package com.packsendme.roadway.bre.rule.sa.test.categoryC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.common.constants.generic.MetricUnitMeasurement_Constants;
import com.packsendme.roadway.bre.model.businessrule.RoadwayCosts;
import com.packsendme.roadway.bre.model.category.Category;
import com.packsendme.roadway.bre.model.location.Location;
import com.packsendme.roadway.bre.model.vehicle.VehicleRule;


public class CategoryBRE_CatC_SA {
	
	VehicleBRE_CatC_SA vehicleBRE_CatC = new VehicleBRE_CatC_SA();
	private String file_country_sa = "src/test/resources/Country_SA.txt";
	private String file_way_sa = "src/test/resources/vehicleCat_C.txt";

	@Test
	public void generateCategory_Testing() throws IOException, URISyntaxException {
		Category category = getCategory_C_Rule();
		ObjectMapper mapper = new ObjectMapper();
		String jsonSouthAmerica = mapper.writeValueAsString(category);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
	}
	
	public Category getCategory_C_Rule(){
		Category categoryRule = new Category();
		categoryRule.name_category = "Cat_A";
		categoryRule.transport = "People";
		categoryRule.weight_min = 3.0;
		categoryRule.weight_max = 3.0;
		categoryRule.unity_measurement_weight_max = MetricUnitMeasurement_Constants.tonelada_UnitMeasurement;
		categoryRule.unity_measurement_weight_min = MetricUnitMeasurement_Constants.tonelada_UnitMeasurement;
		categoryRule.vehicles = vehicleBRE_CatC.getVehicles();
		return categoryRule;
	}
	
 	/*===============================================================================================================================
	 *  LOCATION
	 *===============================================================================================================================
	 */
	
	public List<Location> getLocations() {
		List<Location> locations = new ArrayList<Location>();
		Location locationObj = new Location("Brazil","","","");
		locations.add(locationObj);
		return locations;
	}
	
	/*===============================================================================================================================
	 *  CATEGORY COSTS
	 *===============================================================================================================================
	 */
	
	List<Map<String,List<RoadwayCosts>>> getCategoryCosts() {
		RoadwayCosts ruleCostsObj = null;
		Map<String,List<RoadwayCosts>> cateCostsMap = new HashMap<String,List<RoadwayCosts>>();
		List<Map<String,List<RoadwayCosts>>> costsListToMap = new ArrayList<Map<String,List<RoadwayCosts>>>(); 
		
		List<String> countryL = getCountry();
		List<VehicleRule> vehiclesL = vehicleBRE_CatC.getVehicles();

		for(String country : countryL) {
			List<RoadwayCosts> ruleCostsL = new ArrayList<RoadwayCosts>();
			for(VehicleRule vehicleObj : vehiclesL) {
				ruleCostsObj = new RoadwayCosts(country, vehicleObj.vehicle_type, 0.20, 0.30, 0.40, 0.0, 4.50, "R$", true);
				ruleCostsL.add(ruleCostsObj);
				ruleCostsObj = new RoadwayCosts();
			}
			cateCostsMap.put(country, ruleCostsL);
		}
		costsListToMap.add(cateCostsMap);
		return costsListToMap;
	}
	
	/*===============================================================================================================================
	 *  S U P P O R T --  O P E R A T I O N A L 
	 *===============================================================================================================================
	 */
	
	public List<String> getCountry() {
		List<String> countryL = new ArrayList<String>();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(file_country_sa));
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
	
	public List<String> getWay() {
		List<String> wayL = new ArrayList<String>();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(file_way_sa));
			String line = reader.readLine();
			while(line != null) {
				System.out.println(line);
				wayL.add(line);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return wayL;
	}
}
