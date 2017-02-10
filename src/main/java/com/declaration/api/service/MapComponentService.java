package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.MapComponentDataFilter;
import com.declaration.api.components.entity.MapComponentDeclarations;
import com.declaration.api.components.interfaces.IMapComponent;

/**
 * Service for work with component map
 * @author olegnovatskiy
 */
@Service
public class MapComponentService {

	@Autowired
	private IMapComponent iMapComponentAPI;
			
	/**
	 * Method that will return informations for map component
	 * 
	 * @param filterForMap
	 * @return List<InfoForMap> - list of informations
	 */
	public List<MapComponentDeclarations> search(MapComponentDataFilter mapComponentFilter){
		return iMapComponentAPI.search(mapComponentFilter);
	}
	
}
