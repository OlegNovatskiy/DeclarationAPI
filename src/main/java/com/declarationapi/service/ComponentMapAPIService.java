package com.declarationapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declarationapi.components.entity.ComponentMapFilter;
import com.declarationapi.components.entity.ComponentMapInfo;
import com.declarationapi.components.interfaces.IMapAPI;

/**
 * Service for work with api for map
 * @author olegnovatskiy
 */
@Service
public class ComponentMapAPIService {

	@Autowired
	private IMapAPI iMapAPI;
			
	/**
	 * Method that will return informations for map 
	 * 
	 * @param filterForMap
	 * @return List<InfoForMap> - list of informations
	 */
	public List<ComponentMapInfo> findInfoForMap(ComponentMapFilter filterForMap){
		return iMapAPI.findInfoForMap(filterForMap);
	}
	
}
