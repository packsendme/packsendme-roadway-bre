package com.packsendme.roadway.bre.rule.sa.test.categoryC;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.common.constants.generic.MetricUnitMeasurement_Constants;
import com.packsendme.lib.common.constants.way.Roadway_SA_Constants;
import com.packsendme.roadway.bre.model.vehicle.VehicleBRE;
import com.packsendme.roadway.bre.model.vehicle.VehicleTypeBRE;

public class VehicleBRE_CatC_SA {
	
	/*===============================================================================================================================
	 *  V E H I C L E 
	 *===============================================================================================================================
	 */
	@Test
	void getVehicleBRE() throws URISyntaxException, IOException {

		VehicleBRE vehicle_model = getVehicleInstance();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonSouthAmerica = mapper.writeValueAsString(vehicle_model);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
	}
	
	public VehicleBRE getVehicleInstance() {
		VehicleBRE vehicle_model1 = new VehicleBRE();
		List<String> bodyworkL = getBodyWork();
		vehicle_model1 = new VehicleBRE(getVehicleType(1).type_vehicle, bodyworkL, 6.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		return vehicle_model1;
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

}
