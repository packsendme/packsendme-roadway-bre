package com.packsendme.roadway.bre.model.businessrule;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.packsendme.roadway.bre.model.category.CategoryCosts;
import com.packsendme.roadway.bre.model.category.CategoryRule;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CategoryBRE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CategoryRule categoryRule;
	public Map<String,Map<String, CategoryCosts>> categoryCosts = new HashMap<String, Map<String, CategoryCosts>>();
	

	public CategoryBRE(CategoryRule categoryRule, Map<String, Map<String, CategoryCosts>> categoryCosts) {
		super();
		this.categoryRule = categoryRule;
		this.categoryCosts = categoryCosts;
	}


	public CategoryBRE() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
