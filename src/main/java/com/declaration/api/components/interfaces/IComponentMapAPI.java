package com.declaration.api.components.interfaces;

import java.util.List;

import com.declaration.api.components.entity.ComponentMapFilter;
import com.declaration.api.components.entity.ComponentMapInfo;

/**
 * Interface for API of map
 *
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IComponentMapAPI {
	
	/**
	 * Method find info for map
	 * 
	 * @param filterForMap - filter for search
	 * @return List<InfoForMap> - informations for map
	 */
	public List<ComponentMapInfo> findInfoMap(ComponentMapFilter componentMapFilter);
	
}
