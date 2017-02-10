package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.FilterShortDeclaration;
import com.declaration.api.components.entity.ShortDeclaration;
import com.declaration.api.components.interfaces.IDeclarations;

/**
 * Service for work with component filter
 * @author olegnovatskiy
 */
@Service
public class DeclarationService {

	@Autowired
	private IDeclarations iDeclarations;
	
	/**
	 * Method that will return informations for component filter 
	 * 
	 * @param filterShortDeclaration
	 * @return List<ComponentFilterInfo> - list information for filter component 
	 */
	public List<ShortDeclaration> search(FilterShortDeclaration filterShortDeclaration){
		return iDeclarations.search(filterShortDeclaration);
	}
	
}
