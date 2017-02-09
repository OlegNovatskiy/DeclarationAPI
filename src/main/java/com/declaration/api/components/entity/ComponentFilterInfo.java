package com.declaration.api.components.entity;

import java.io.Serializable;

public class ComponentFilterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String position;
	private String location;

	public ComponentFilterInfo(String id, String firstName, String lastName, String middleName, String position,
			String location) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.position = position;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
