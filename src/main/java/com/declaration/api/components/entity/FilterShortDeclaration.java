package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model holds set of data to filter of declaration
 * 
 * @author olegnovatskiy
 *
 */
public class FilterShortDeclaration extends FilterRegionStatistic implements Serializable {

	private static final long serialVersionUID = 1L;

	private String regionDeclarant;
	private Integer limitBatch;
	private Integer pageBatch;
	private String firstName;
	private String lastName;
	private String middleName;

	public String getRegionDeclarant() {
		return regionDeclarant;
	}

	public void setRegionDeclarant(String regionDeclarant) {
		this.regionDeclarant = regionDeclarant;
	}

	public Integer getLimitBatch() {
		return limitBatch;
	}

	public void setLimitBatch(Integer limitBatch) {
		this.limitBatch = limitBatch;
	}

	public Integer getPageBatch() {
		return pageBatch;
	}

	public void setPageBatch(Integer pageBatch) {
		this.pageBatch = pageBatch;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
