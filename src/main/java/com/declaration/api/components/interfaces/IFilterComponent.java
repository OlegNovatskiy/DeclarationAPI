package com.declaration.api.components.interfaces;

import com.declaration.api.components.entity.FilterComponentDataFilter;
import com.declaration.api.components.entity.FilterComponentDeclarations;

import java.util.List;

/**
 * Interface for component filter
 * 
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IFilterComponent {
	
	/**
	 * Method find info for filter component
	 * 
	 * @param componentFilterDataFilter
	 * @return List<ComponentFilterInfo> - list information for filter component
	 */
	public List<FilterComponentDeclarations> search(FilterComponentDataFilter componentFilterDataFilter);

}
