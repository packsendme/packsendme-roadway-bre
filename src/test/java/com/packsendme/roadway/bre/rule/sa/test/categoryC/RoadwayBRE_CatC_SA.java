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
import com.packsendme.roadway.bre.model.businessrule.BusinessRuleRoadwayBRE;
import com.packsendme.roadway.bre.model.businessrule.VehicleCostsBRE;
import com.packsendme.roadway.bre.model.category.CategoryBRE;
import com.packsendme.roadway.bre.model.vehicle.BodyworkBRE;
import com.packsendme.roadway.bre.model.vehicle.VehicleBRE;
import com.packsendme.roadway.bre.model.vehicle.VehicleTypeBRE;

public class RoadwayBRE_CatC_SA {

	private String jsonSouthAmerica = null;
	private String url_json = "src/test/resources/RoadwayBRE_SA_CatC.json";
	private String file_country_sa = "src/test/resources/Country_SA.txt";
	private String file_way_sa = "src/test/resources/vehicleCat_C.txt";
	
	private final String name_rule = "RoadwayCatC-SouthAmerica-BRE";

	// Rule-Instance
	VehicleBRE ruleInstance = new VehicleBRE();
	// Rule-Costs
	VehicleCostsBRE ruleCosts = new VehicleCostsBRE();
	
	
	/*===============================================================================================================================
	*  B U S S I N E S  -  R U L E 
	*=============================================================================================================================== 
	*/
	
	@Test
	void getBusinessRule() throws URISyntaxException, IOException {
		BusinessRuleRoadwayBRE roadwayBRE = new BusinessRuleRoadwayBRE();

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

	public CategoryBRE getCategory() {
		CategoryBRE categoryC = new CategoryBRE(Roadway_SA_Constants.ROADWAY_CATEGORY_C, getVehicleInstance(), 1.500, 6.0, 2, 
				MetricUnitMeasurement_Constants.kilograma_UnitMeasurement, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement); 
		return categoryC;
	}

	/*===============================================================================================================================
	 *  V E H I C L E 
	 *===============================================================================================================================
	 */
	
	public List<VehicleBRE> getVehicleInstance() {
		VehicleBRE vehicle_model1 = new VehicleBRE();
		VehicleBRE vehicle_model2 = new VehicleBRE();
		VehicleBRE vehicle_model3 = new VehicleBRE();
		List<VehicleBRE> vehicleL = new ArrayList<VehicleBRE>();

		List<String> bodyworkL = getBodyWork();
		
		vehicle_model1 = new VehicleBRE(getVehicleType(1).type_vehicle, bodyworkL, 6.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		vehicle_model2 = new VehicleBRE(getVehicleType(2).type_vehicle, bodyworkL, 12.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		vehicle_model3 = new VehicleBRE(getVehicleType(3).type_vehicle, bodyworkL, 16.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		
		vehicleL.add(vehicle_model1);
		vehicleL.add(vehicle_model2);
		vehicleL.add(vehicle_model3);
		
		return vehicleL;
	}
	
	public VehicleTypeBRE getVehicleType(int type) {
		VehicleTypeBRE vehicleType = new VehicleTypeBRE();
		
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
	
	public List<String>  getBodyWork() {
		List<String> bodywork_vehicleL = new ArrayList<String>();
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BASCULANTE);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BAU_ALIMINIO);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BAU_FRIGORIFICO);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BAU_LONADO);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_GRADE_BAIXA);
		return bodywork_vehicleL;
	}
	
	/*===============================================================================================================================
	 *  V E H I C L E - C O S T S 
	 *===============================================================================================================================
	 */
	
	Map<String, Map<String, VehicleCostsBRE>> getVehicleCosts() {
		VehicleCostsBRE ruleCosts = null;
		Map<String,Map<String, VehicleCostsBRE>> costsL = new HashMap<String,Map<String, VehicleCostsBRE>>();
		
		List<String> countryL = getCountry();
		List<String> wayL = getWay();
		Map<String, VehicleCostsBRE> costsCountryWayL = new HashMap<String,VehicleCostsBRE>();
		
		for(String country : countryL) {
			for(String way : wayL) {
				
				if(way.equals(Roadway_SA_Constants.ROADWAY_URBANO)) {
					ruleCosts = new VehicleCostsBRE(0.20, 0.30, 0.40, 0.0, 4.50, "R$");
				}
				else if(way.equals(Roadway_SA_Constants.ROADWAY_TOCO12)) {
					ruleCosts = new VehicleCostsBRE(0.20, 0.30, 0.40, 10.0, 4.50, "R$");
				}
				else if(way.equals(Roadway_SA_Constants.ROADWAY_TOCO16)) {
					ruleCosts = new VehicleCostsBRE(0.20, 0.30, 0.40, 0.0, 4.50, "R$");
				}
				costsCountryWayL.put(way,ruleCosts);
				ruleCosts = new VehicleCostsBRE();
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
			BusinessRuleRoadwayBRE obj = mapper.readValue(new File(absolutePath), BusinessRuleRoadwayBRE.class);
			Assert.notNull(obj);
		}
		else {
			try (FileWriter fileWriter = new FileWriter(url_json, true)) {
			    fileWriter.write(jsonSouthAmerica);
			}
		}
	}
}
