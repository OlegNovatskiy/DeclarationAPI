package com.declaration.api.components.interfaces;

import com.declaration.api.components.entity.ComponentFilterDataFilter;
import com.declaration.api.components.entity.ComponentFilterInfo;

import java.util.List;

/**
 * Interface for component filter
 * 
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IComponentFilter {
	
	/**
	 * Method find info for filter component
	 * 
	 * @param componentFilterDataFilter
	 * @return List<ComponentFilterInfo> - list information for filter component
	 */
	public List<ComponentFilterInfo> findInfoComponentFilter(ComponentFilterDataFilter componentFilterDataFilter);

}
