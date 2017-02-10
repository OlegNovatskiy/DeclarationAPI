package com.declaration.api.components.entity;

import java.io.Serializable;

/**
 * Model holds statistic data of region
 * @author olegnovatskiy
 *
 */
public class RegionStatistic implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nameRegion;
	private Integer countDeclaration;
	private Integer salaryOfYear;
	private Integer assetsOfYear;

	public RegionStatistic(String nameRegion, Integer countDeclaration, Integer salaryOfYear, Integer assetsOfyear) {
		this.nameRegion = nameRegion;
		this.countDeclaration = countDeclaration;
		this.salaryOfYear = salaryOfYear;
		this.assetsOfYear = assetsOfyear;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
	}

	public Integer getCountDeclaration() {
		return countDeclaration;
	}

	public void setCountDeclaration(Integer countDeclaration) {
		this.countDeclaration = countDeclaration;
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
