package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.ComponentFilterDataFilter;
import com.declaration.api.components.entity.ComponentFilterInfo;
import com.declaration.api.components.interfaces.IComponentFilter;

/**
 * Service for work with component filter
 * @author olegnovatskiy
 */
@Service
public class ComponentFilterService {

	@Autowired
	private IComponentFilter iComponentFilter;
	
	/**
	 * Method that will return informations for component filter 
	 * 
	 * @param componentFilterDataFilter
	 * @return List<ComponentFilterInfo> - list information for filter component 
	 */
	public List<ComponentFilterInfo> findInfoComponentFilter(ComponentFilterDataFilter componentFilterDataFilter){
		return iComponentFilter.findInfoComponentFilter(componentFilterDataFilter);
	}
	
}
