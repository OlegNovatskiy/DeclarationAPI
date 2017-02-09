package com.declaration.api.components.entity;

import java.io.Serializable;
import java.time.Year;

/**
 * Model hold filters into map component
 * @author olegnovatskiy
 *
 */
public class ComponentMapDataFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String position;
	private Integer yearCreate;
	
	public ComponentMapDataFilter(){
		this.position = "";
		this.yearCreate = Year.now().getValue();
	}

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
