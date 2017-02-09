package com.declaration.api.components.interfaces;

import java.util.List;

import com.declaration.api.components.entity.ComponentMapDataFilter;
import com.declaration.api.components.entity.ComponentMapInfo;

/**
 * Interface for map component
 *
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IComponentMap {
	
	/**
	 * Method find info for map component
	 * 
	 * @param filterForMap - filter for search
	 * @return List<ComponentMapInfo> - informations for map component
	 */
	public List<ComponentMapInfo> findInfoComponentMap(ComponentMapDataFilter componentMapFilter);
	
}
