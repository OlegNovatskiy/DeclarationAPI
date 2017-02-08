package com.declarationapi.components.interfaces;

import java.util.List;

import com.declarationapi.components.entity.ComponentMapFilter;
import com.declarationapi.components.entity.ComponentMapInfo;

/**
 * Interface for API of map
 *
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IMapAPI {
	
	/**
	 * Method find info for map
	 * 
	 * @param filterForMap - filter for search
	 * @return List<InfoForMap> - informations for map
	 */
	public List<ComponentMapInfo> findInfoForMap(ComponentMapFilter filterForMap);
	
}
