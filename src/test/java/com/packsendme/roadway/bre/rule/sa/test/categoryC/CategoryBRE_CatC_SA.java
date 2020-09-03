package com.packsendme.roadway.bre.rule.sa.test.categoryC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.common.constants.generic.MetricUnitMeasurement_Constants;
import com.packsendme.lib.common.constants.way.Roadway_SA_Constants;
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
	CategoryRule getCategory_C_Rule() throws URISyntaxException, IOException {

		CategoryRule categoryBRE = new CategoryRule();
		categoryBRE.categoryType = getCategoryType();
		categoryBRE.locations = getLocations();
		categoryBRE.vehicles = vehicleBRE_CatC.getVehicles();
		categoryBRE.categoryCosts = getCategoryCosts();
				
		ObjectMapper mapper = new ObjectMapper();
		String jsonSouthAmerica = mapper.writeValueAsString(categoryBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
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
	
	Map<String, Map<String, CategoryCosts>> getCategoryCosts() {
		CategoryCosts ruleCosts = null;
		Map<String,Map<String, CategoryCosts>> costsToCountryL = new HashMap<String,Map<String, CategoryCosts>>();

		List<String> countryL = getCountry();
		List<String> wayL = getWay();
		List<VehicleRule> vehiclesL = vehicleBRE_CatC.getVehicles();
		Map<String, CategoryCosts> costsCountryWay_Map = new HashMap<String,CategoryCosts>();

		for(String country : countryL) {
			
			for(VehicleRule vehicleObj : vehiclesL) {
				ruleCosts = new CategoryCosts(vehicleObj.vehicle_type, "BR", 0.20, 0.30, 0.40, 0.0, 4.50, "R$");
				costsCountryWay_Map.put(vehicleObj.vehicle_type,ruleCosts);
				ruleCosts = new CategoryCosts();
			}
			costsToCountryL.put(country, costsCountryWay_Map);
		}
		return costsToCountryL;
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
