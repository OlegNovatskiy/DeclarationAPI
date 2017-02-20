package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model holds short set information about declaration
 * 
 * @author olegnovatskiy
 *
 */
public class ShortDeclaration implements Serializable {

	private static final long serialVersionUID = 1L;

	private String declarationId;
	private Integer yearCreate;
	private String firstName;
	private String lastName;
	private String middleName;
	private String positionDeclarant;
	private String actualRegionDeclarant;

	public ShortDeclaration(String declarationId, Integer yearCreate, String firstName, String lastName,
			String middleName, String positionDeclarant, String actualRegionDeclarant) {
		super();
		this.declarationId = declarationId;
		this.yearCreate = yearCreate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.positionDeclarant = positionDeclarant;
		this.actualRegionDeclarant = actualRegionDeclarant;
	}

	public String getDeclarationId() {
		return declarationId;
	}

	public void setDeclarationId(String declarationId) {
		this.declarationId = declarationId;
	}

	public Integer getYearCreate() {
		return yearCreate;
	}

	public void setYearCreate(Integer yearCreate) {
		this.yearCreate = yearCreate;
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

	public String getPositionDeclarant() {
		return positionDeclarant;
	}

	public void setPositionDeclarant(String positionDeclarant) {
		this.positionDeclarant = positionDeclarant;
	}

	public String getActualRegionDeclarant() {
		return actualRegionDeclarant;
	}

	public void setActualRegionDeclarant(String actualRegionDeclarant) {
		this.actualRegionDeclarant = actualRegionDeclarant;
	}

}