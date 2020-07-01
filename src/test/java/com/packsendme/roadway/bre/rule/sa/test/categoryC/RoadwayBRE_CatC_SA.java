package com.packsendme.roadway.bre.rule.sa.test.categoryC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.common.constants.generic.MetricUnitMeasurement_Constants;
import com.packsendme.lib.common.constants.way.Roadway_SA_Constants;
import com.packsendme.roadway.bre.model.businessrule.BusinessRuleRoadway_Model;
import com.packsendme.roadway.bre.model.businessrule.VehicleCosts_Model;
import com.packsendme.roadway.bre.model.category.Category_Model;
import com.packsendme.roadway.bre.model.vehicle.VehicleBodyWork_Model;
import com.packsendme.roadway.bre.model.vehicle.VehicleType_Model;
import com.packsendme.roadway.bre.model.vehicle.Vehicle_Model;

public class RoadwayBRE_CatC_SA {

	private String jsonSouthAmerica = null;
	private String url_json = "src/test/resources/RoadwayBRE_SA_CatC.json";
	private String file_country_sa = "src/test/resources/Country_SA.txt";
	private String file_way_sa = "src/test/resources/vehicleCat_C.txt";
	
	private final String name_rule = "RoadwayCatC-SouthAmerica-BRE";

	// Rule-Instance
	Vehicle_Model ruleInstance = new Vehicle_Model();
	// Rule-Costs
	VehicleCosts_Model ruleCosts = new VehicleCosts_Model();
	
	
	/*===============================================================================================================================
	*  B U S S I N E S  -  R U L E 
	*=============================================================================================================================== 
	*/
	
	@Test
	void getBusinessRule() throws URISyntaxException, IOException {
		BusinessRuleRoadway_Model roadwayBRE = new BusinessRuleRoadway_Model();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dtNowS = sdf.format(new Date());
		
		// RoadwayModel-CATEGORY (C)
		roadwayBRE.rule_name = name_rule;
		roadwayBRE.category_name = Roadway_SA_Constants.ROADWAY_CATEGORY_C;
		roadwayBRE.date_creation = dtNowS;
		roadwayBRE.date_change = null;
		roadwayBRE.status = "Active";
		roadwayBRE.vehicleInstance = getVehicleInstance();
		roadwayBRE.vehicleCosts = getVehicleCosts();
		
		ObjectMapper mapper = new ObjectMapper();
		jsonSouthAmerica = mapper.writeValueAsString(roadwayBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		inputJsonFileSouthAmerica(jsonSouthAmerica);
	}
	
	/*===============================================================================================================================
	 *  C A T E G O R Y
	 *=============================================================================================================================== 
	 */

	public Category_Model getCategory() {
		Category_Model categoryC = new Category_Model(Roadway_SA_Constants.ROADWAY_CATEGORY_C, getVehicleInstance(), 1.500, 6.0, 2, 
				MetricUnitMeasurement_Constants.kilograma_UnitMeasurement, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement); 
		return categoryC;
	}

	/*===============================================================================================================================
	 *  V E H I C L E 
	 *===============================================================================================================================
	 */
	
	public List<Vehicle_Model> getVehicleInstance() {
		Vehicle_Model vehicle_model1 = new Vehicle_Model();
		Vehicle_Model vehicle_model2 = new Vehicle_Model();
		Vehicle_Model vehicle_model3 = new Vehicle_Model();
		List<Vehicle_Model> vehicleL = new ArrayList<Vehicle_Model>();

		List<VehicleBodyWork_Model> bodywork_vehicleL = getBodyWork();
		vehicle_model1 = new Vehicle_Model(getVehicleType(1), bodywork_vehicleL, 6.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		vehicle_model2 = new Vehicle_Model(getVehicleType(2), bodywork_vehicleL, 12.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		vehicle_model3 = new Vehicle_Model(getVehicleType(3), bodywork_vehicleL, 16.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		
		vehicleL.add(vehicle_model1);
		vehicleL.add(vehicle_model2);
		vehicleL.add(vehicle_model3);
		
		return vehicleL;
	}
	
	public VehicleType_Model getVehicleType(int type) {
		VehicleType_Model vehicleType = new VehicleType_Model();
		
		if(type == 1) {
			vehicleType.type_vehicle = Roadway_SA_Constants.ROADWAY_URBANO;
		}
		else if(type == 2) {
			vehicleType.type_vehicle = Roadway_SA_Constants.ROADWAY_TOCO12;
		} 
		else if(type == 3) {
			vehicleType.type_vehicle = Roadway_SA_Constants.ROADWAY_TOCO16;
		} 
		return vehicleType;
	}
	
	public List<VehicleBodyWork_Model>  getBodyWork() {
		List<VehicleBodyWork_Model> bodywork_vehicleL = new ArrayList<VehicleBodyWork_Model>();
		VehicleBodyWork_Model vehicleBodyWork_Model = new VehicleBodyWork_Model();
		
		//CASE 1 
		vehicleBodyWork_Model = new VehicleBodyWork_Model();
		vehicleBodyWork_Model.name = Roadway_SA_Constants.BODYWORK_BASCULANTE;
		bodywork_vehicleL.add(vehicleBodyWork_Model);

		//CASE 2
		vehicleBodyWork_Model = new VehicleBodyWork_Model();
		vehicleBodyWork_Model.name = Roadway_SA_Constants.BODYWORK_BAU_ALIMINIO;
		bodywork_vehicleL.add(vehicleBodyWork_Model);
		
		//CASE 3
		vehicleBodyWork_Model = new VehicleBodyWork_Model();
		vehicleBodyWork_Model.name = Roadway_SA_Constants.BODYWORK_BAU_FRIGORIFICO;
		bodywork_vehicleL.add(vehicleBodyWork_Model);
		
		//CASE 4
		vehicleBodyWork_Model = new VehicleBodyWork_Model();
		vehicleBodyWork_Model.name = Roadway_SA_Constants.BODYWORK_BAU_LONADO;
		bodywork_vehicleL.add(vehicleBodyWork_Model);

		//CASE 5
		vehicleBodyWork_Model = new VehicleBodyWork_Model();
		vehicleBodyWork_Model.name = Roadway_SA_Constants.BODYWORK_GRADE_BAIXA;
		bodywork_vehicleL.add(vehicleBodyWork_Model);
		
		return bodywork_vehicleL;
	}
	
	/*===============================================================================================================================
	 *  V E H I C L E - C O S T S 
	 *===============================================================================================================================
	 */
	
	Map<String, Map<String, VehicleCosts_Model>> getVehicleCosts() {
		VehicleCosts_Model ruleCosts = null;
		Map<String,Map<String, VehicleCosts_Model>> costsL = new HashMap<String,Map<String, VehicleCosts_Model>>();
		
		List<String> countryL = getCountry();
		List<String> wayL = getWay();
		Map<String, VehicleCosts_Model> costsCountryWayL = new HashMap<String,VehicleCosts_Model>();
		
		for(String country : countryL) {
			for(String way : wayL) {
				
				if(way.equals(Roadway_SA_Constants.ROADWAY_URBANO)) {
					ruleCosts = new VehicleCosts_Model(0.20, 0.30, 0.40, 0.0, 4.50, "R$");
				}
				else if(way.equals(Roadway_SA_Constants.ROADWAY_TOCO12)) {
					ruleCosts = new VehicleCosts_Model(0.20, 0.30, 0.40, 10.0, 4.50, "R$");
				}
				else if(way.equals(Roadway_SA_Constants.ROADWAY_TOCO16)) {
					ruleCosts = new VehicleCosts_Model(0.20, 0.30, 0.40, 0.0, 4.50, "R$");
				}
				costsCountryWayL.put(way,ruleCosts);
				ruleCosts = new VehicleCosts_Model();
			}
			costsL.put(country, costsCountryWayL);
		}
		return costsL;
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

	void inputJsonFileSouthAmerica(String jsonSouthAmerica) throws IOException, URISyntaxException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(url_json);
		if (file.length() != 0) {
			String absolutePath = file.getAbsolutePath();
			BusinessRuleRoadway_Model obj = mapper.readValue(new File(absolutePath), BusinessRuleRoadway_Model.class);
			Assert.notNull(obj);
		}
		else {
			try (FileWriter fileWriter = new FileWriter(url_json, true)) {
			    fileWriter.write(jsonSouthAmerica);
			}
		}
	}
}
