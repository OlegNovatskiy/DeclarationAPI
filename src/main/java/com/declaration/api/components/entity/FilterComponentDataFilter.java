package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model hold filters into filter component
 * 
 * @author olegnovatskiy
 *
 */
public class FilterComponentDataFilter extends MapComponentDataFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String location;
	private Integer limit;
	private Integer page;
	private String firstName;
	private String lastName;
	private String middleName;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
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
