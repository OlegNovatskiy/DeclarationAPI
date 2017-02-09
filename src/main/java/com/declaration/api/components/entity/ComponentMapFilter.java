package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model for hold filter
 * @author olegnovatskiy
 *
 */
public class ComponentMapFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String positionDeclarant;
	private Integer yearCreateDeclaration;
	
	public ComponentMapFilter(){}
	
	public ComponentMapFilter(String positionDeclarant, Integer yearCreateDeclaration) {
		this.positionDeclarant = positionDeclarant;
		this.yearCreateDeclaration = yearCreateDeclaration;
	}

	public String getPositionDeclarant() {
		return positionDeclarant;
	}

	public void setPositionDeclarant(String positionDeclarant) {
		this.positionDeclarant = positionDeclarant;
	}

	public Integer getYearCreateDeclaration() {
		return yearCreateDeclaration;
	}

	public void setYearCreateDeclaration(Integer yearCreateDeclaration) {
		this.yearCreateDeclaration = yearCreateDeclaration;
	}

}
