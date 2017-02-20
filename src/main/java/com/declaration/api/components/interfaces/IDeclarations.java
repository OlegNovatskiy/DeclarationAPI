package com.declaration.api.components.interfaces;

import com.declaration.api.components.entity.FilterShortDeclaration;
import com.declaration.api.components.entity.ShortDeclaration;

import java.util.List;

/**
 * Interface for component filter
 * 
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IDeclarations {
	
	/**
	 * Method find info for filter component
	 * 
	 * @param filterShortDeclaration
	 * @return List<ShortDeclaration> - list information for filter component
	 */
	public List<ShortDeclaration> search(FilterShortDeclaration filterShortDeclaration);

}
