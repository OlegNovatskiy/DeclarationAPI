package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model hold filters into map component
 * @author olegnovatskiy
 *
 */
public class MapComponentDataFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String position;
	private Integer yearCreate;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getYearCreate() {
		return yearCreate;
	}

	public void setYearCreate(Integer yearCreate) {
		this.yearCreate = yearCreate;
	}
	
}
