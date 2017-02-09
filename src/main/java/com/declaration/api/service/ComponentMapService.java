package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.ComponentMapDataFilter;
import com.declaration.api.components.entity.ComponentMapInfo;
import com.declaration.api.components.interfaces.IComponentMap;

/**
 * Service for work with component map
 * @author olegnovatskiy
 */
@Service
public class ComponentMapService {

	@Autowired
	private IComponentMap iComponentMapAPI;
			
	/**
	 * Method that will return informations for map component
	 * 
	 * @param filterForMap
	 * @return List<InfoForMap> - list of informations
	 */
	public List<ComponentMapInfo> findInfoComponentMap(ComponentMapDataFilter componentMapFilter){
		return iComponentMapAPI.findInfoComponentMap(componentMapFilter);
	}
	
}
