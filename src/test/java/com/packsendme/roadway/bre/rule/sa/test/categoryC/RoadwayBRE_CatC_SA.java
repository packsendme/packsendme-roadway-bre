package com.packsendme.roadway.bre.rule.sa.test.categoryC;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.roadway.bre.model.businessrule.RoadwayBRE;
import com.packsendme.roadway.bre.model.businessrule.RoadwayCosts;
import com.packsendme.roadway.bre.model.category.Category;
import com.packsendme.roadway.bre.model.location.Location;


public class RoadwayBRE_CatC_SA {

	private String jsonSouthAmerica = null;
	private String url_json = "src/test/resources/RoadwayBRE_SA_CatC.json";
	private final String name_rule = "People";

	// Rule-Costs
	RoadwayCosts ruleCosts = new RoadwayCosts();
	

	
	
	/*===============================================================================================================================
	*  B U S S I N E S  -  R U L E 
	*=============================================================================================================================== 
	*/
	
	//@Test
	void getBusinessRule() throws URISyntaxException, IOException{
		RoadwayBRE roadwayBRE = new RoadwayBRE();
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dtNowS = sdf.format(new Date());
		
		// RoadwayModel-CATEGORY (C)
		roadwayBRE.transport = name_rule;
 		roadwayBRE.date_creation = dtNowS;
		roadwayBRE.date_change = null;
		roadwayBRE.status = "Active";
		roadwayBRE.categories = getCategory();
		ObjectMapper mapper = new ObjectMapper();
		jsonSouthAmerica = mapper.writeValueAsString(roadwayBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		inputJsonFileSouthAmerica(jsonSouthAmerica);
	}
	
	/*===============================================================================================================================
	 *  C A T E G O R Y / C O S T S
	 *=============================================================================================================================== 
	 */

	public List<Category> getCategory() throws URISyntaxException, IOException {
		CategoryBRE_CatC_SA catTestC = new CategoryBRE_CatC_SA();
		Category category = catTestC.getCategory_C_Rule();
		List<Category> categoryL = new ArrayList<Category>();
		categoryL.add(category);
		return categoryL;
	}
	
	/*===============================================================================================================================
	 *  LOCATION
	 *===============================================================================================================================
	 */
	
	public Location getLocation() {
		Location locationObj = new Location("Brazil","","","");
		return locationObj;
	}
	
	
	/*===============================================================================================================================
	 *  S U P P O R T --  O P E R A T I O N A L 
	 *===============================================================================================================================
	 */
	
	void inputJsonFileSouthAmerica(String jsonSouthAmerica) throws IOException, URISyntaxException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(url_json);
		if (file.length() != 0) {
			String absolutePath = file.getAbsolutePath();
			RoadwayBRE obj = mapper.readValue(new File(absolutePath), RoadwayBRE.class);
			Assert.notNull(obj);
		}
		else {
			try (FileWriter fileWriter = new FileWriter(url_json, true)) {
			    fileWriter.write(jsonSouthAmerica);
			}
		}
	}
}
