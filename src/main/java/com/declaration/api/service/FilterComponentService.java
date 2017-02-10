package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.FilterComponentDataFilter;
import com.declaration.api.components.entity.FilterComponentDeclarations;
import com.declaration.api.components.interfaces.IFilterComponent;

/**
 * Service for work with component filter
 * @author olegnovatskiy
 */
@Service
public class FilterComponentService {

	@Autowired
	private IFilterComponent iFilterComponent;
	
	/**
	 * Method that will return informations for component filter 
	 * 
	 * @param filterComponentDataFilter
	 * @return List<ComponentFilterInfo> - list information for filter component 
	 */
	public List<FilterComponentDeclarations> search(FilterComponentDataFilter filterComponentDataFilter){
		return iFilterComponent.search(filterComponentDataFilter);
	}
	
}
