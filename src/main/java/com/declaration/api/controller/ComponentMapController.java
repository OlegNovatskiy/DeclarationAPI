 package com.declaration.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.ComponentMapDataFilter;
import com.declaration.api.components.entity.ComponentMapInfo;
import com.declaration.api.service.ComponentMapService;

/**
 * Controller for component map
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/ComponentMapAPI")
public class ComponentMapController {
	
	@Autowired
	private ComponentMapService mapAPIService;
	
	/**
	 * Method finding filtered informations about regions(count declarations, name region, salaries and assets of year)
	 * RequestMethod for form - POST
	 *
	 * @param componentMapFilter - data for filter
	 * @return List<ComponentMapInfo> - list of filtered info 
	 */ 
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public List<ComponentMapInfo> findFilteredInfoComponentMap(@RequestBody ComponentMapDataFilter componentMapFilter){
		
		return mapAPIService.findInfoComponentMap(componentMapFilter);	
	}
	
}
