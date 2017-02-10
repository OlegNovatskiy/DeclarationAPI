package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model holds set of data to filter that select data from region for statistic
 * 
 * @author olegnovatskiy
 *
 */
public class FilterRegionStatistic implements Serializable {

	private static final long serialVersionUID = 1L;

	private String positionDeclarant;
	private Integer yearCreateDeclaration;

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
