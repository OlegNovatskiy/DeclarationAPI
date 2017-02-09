package com.declaration.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.ComponentFilterDataFilter;
import com.declaration.api.components.entity.ComponentFilterInfo;
import com.declaration.api.service.ComponentFilterService;

/**
 * Controller for component filter
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/ComponentFilterAPI")
public class ComponentFilterController {

	@Autowired 
	private ComponentFilterService componentFilterService;
		
	/**
	 * Method finding informations for component filter
	 * RequestMethod - POST
	 * 
	 * @param componentFilterDataFilter - data for filter
	 * @return List<ComponentFilterInfo> - list of information for component filter
	 */
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public List<ComponentFilterInfo> findFilteredInfoComponentFilter(@RequestBody ComponentFilterDataFilter componentFilterDataFilter){		
		
		return componentFilterService.findInfoComponentFilter(componentFilterDataFilter);
	}
	
}
