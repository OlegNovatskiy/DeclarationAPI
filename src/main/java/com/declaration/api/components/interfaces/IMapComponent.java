package com.declaration.api.components.interfaces;

import java.util.List;

import com.declaration.api.components.entity.MapComponentDataFilter;
import com.declaration.api.components.entity.MapComponentDeclarations;

/**
 * Interface for map component
 *
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IMapComponent {
	
	/**
	 * Method find info for map component
	 * 
	 * @param filterForMap - filter for search
	 * @return List<ComponentMapInfo> - informations for map component
	 */
	public List<MapComponentDeclarations> search(MapComponentDataFilter componentMapFilter);
	
}
