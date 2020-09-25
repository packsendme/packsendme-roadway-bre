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
import com.packsendme.roadway.bre.model.businessrule.CategoryBRE;
import com.packsendme.roadway.bre.model.category.CategoryCosts;
import com.packsendme.roadway.bre.model.category.CategoryRule;
import com.packsendme.roadway.bre.model.category.CategoryType;
import com.packsendme.roadway.bre.model.location.LocationRule;
import com.packsendme.roadway.bre.model.vehicle.VehicleRule;


public class CategoryBRE_CatC_SA {
	
	VehicleBRE_CatC_SA vehicleBRE_CatC = new VehicleBRE_CatC_SA();
	private String file_country_sa = "src/test/resources/Country_SA.txt";
	private String file_way_sa = "src/test/resources/vehicleCat_C.txt";

	@Test
	public void generateCategory_Testing() throws IOException, URISyntaxException {
		CategoryBRE categoryBRE = getCategory_C_Rule();
		ObjectMapper mapper = new ObjectMapper();
		String jsonSouthAmerica = mapper.writeValueAsString(categoryBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
	}
	
	public CategoryBRE getCategory_C_Rule(){
		CategoryRule categoryRule = new CategoryRule();
		categoryRule.categoryType = getCategoryType();
		categoryRule.locations = getLocations();
		categoryRule.vehicles = vehicleBRE_CatC.getVehicles();
		categoryRule.categoryCosts = getCategoryCosts();
		CategoryBRE categoryBRE = new CategoryBRE(categoryRule);
		return categoryBRE;
	}
	
	/*===============================================================================================================================
	*  CATEGORY - TYPE
	*===============================================================================================================================
	*/

	public CategoryType getCategoryType() {
		CategoryType categoryType = new CategoryType("Cat_C","Transporte Comercio/Varejista", 3.0, 6.0, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement,
		MetricUnitMeasurement_Constants.tonelada_UnitMeasurement);
		return categoryType;
	}
 
 	/*===============================================================================================================================
	 *  LOCATION
	 *===============================================================================================================================
	 */
	
	public List<LocationRule> getLocations() {
		List<LocationRule> locations = new ArrayList<LocationRule>();
		LocationRule locationObj = new LocationRule("Brazil","","","");
		locations.add(locationObj);
		return locations;
	}
	
	/*===============================================================================================================================
	 *  CATEGORY COSTS
	 *===============================================================================================================================
	 */
	
	List<Map<String,List<CategoryCosts>>> getCategoryCosts() {
		CategoryCosts ruleCostsObj = null;
		Map<String,List<CategoryCosts>> cateCostsMap = new HashMap<String,List<CategoryCosts>>();
		List<Map<String,List<CategoryCosts>>> costsListToMap = new ArrayList<Map<String,List<CategoryCosts>>>(); 
		
		List<String> countryL = getCountry();
		List<VehicleRule> vehiclesL = vehicleBRE_CatC.getVehicles();

		for(String country : countryL) {
			List<CategoryCosts> ruleCostsL = new ArrayList<CategoryCosts>();
			for(VehicleRule vehicleObj : vehiclesL) {
				ruleCostsObj = new CategoryCosts(country, vehicleObj.vehicle_type, 0.20, 0.30, 0.40, 0.0, 4.50, "R$");
				ruleCostsL.add(ruleCostsObj);
				ruleCostsObj = new CategoryCosts();
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
