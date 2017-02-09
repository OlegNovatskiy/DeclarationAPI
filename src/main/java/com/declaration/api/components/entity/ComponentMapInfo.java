package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model hold info for map component
 * @author olegnovatskiy
 *
 */
public class ComponentMapInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nameRegion;
	private Integer countDeclarationInRegion;
	private Integer salaryOfYear;
	private Integer assetsOfYear;

	public ComponentMapInfo(String nameRegion, Integer countDeclarationInRegion, Integer salaryOfYear, Integer assetsOfyear) {
		this.nameRegion = nameRegion;
		this.countDeclarationInRegion = countDeclarationInRegion;
		this.salaryOfYear = salaryOfYear;
		this.assetsOfYear = assetsOfyear;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
	}

	public Integer getCountDeclarationInRegion() {
		return countDeclarationInRegion;
	}

	public void setCountDeclarationInRegion(Integer countDeclarationInRegion) {
		this.countDeclarationInRegion = countDeclarationInRegion;
	}

	public Integer getSalaryOfYear() {
		return salaryOfYear;
	}

	public void setSalaryOfYear(Integer salaryOfYear) {
		this.salaryOfYear = salaryOfYear;
	}

	public Integer getAssetsOfYear() {
		return assetsOfYear;
	}

	public void setAssetsOfYear(Integer assetsOfYear) {
		this.assetsOfYear = assetsOfYear;
	}

}
