package com.packsendme.roadway.bre.model.businessrule;

import java.io.Serializable;

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

	public CategoryBRE(CategoryRule categoryRule) {
		super();
		this.categoryRule = categoryRule;
	}

	public CategoryBRE() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
