package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.ComponentMapFilter;
import com.declaration.api.components.entity.ComponentMapInfo;
import com.declaration.api.components.interfaces.IComponentMapAPI;

/**
 * Service for work with api for map
 * @author olegnovatskiy
 */
@Service
public class ComponentMapAPIService {

	@Autowired
	private IComponentMapAPI iComponentMapAPI;
			
	/**
	 * Method that will return informations for map 
	 * 
	 * @param filterForMap
	 * @return List<InfoForMap> - list of informations
	 */
	public List<ComponentMapInfo> findInfoMap(ComponentMapFilter componentMapFilter){
		return iComponentMapAPI.findInfoMap(componentMapFilter);
	}
	
}
