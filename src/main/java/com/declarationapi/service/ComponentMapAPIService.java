package com.declarationapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declarationapi.components.entity.ComponentMapFilter;
import com.declarationapi.components.entity.ComponentMapInfo;
import com.declarationapi.components.interfaces.IComponentMapAPI;

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
