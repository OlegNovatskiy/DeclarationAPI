 package com.declaration.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.ComponentMapFilter;
import com.declaration.api.components.entity.ComponentMapInfo;
import com.declaration.api.service.ComponentMapAPIService;

/**
 * Controller for map API
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/componentamapapi")
public class ComponentMapAPIController {
	
	@Autowired
	private ComponentMapAPIService mapAPIService;
	
	/**
	 * Method finding informations about regions(count declarations, name region, middle salary of year)
	 * RequestMethod for form - GET
	 * 
	 * @return List<ComponentMapInfo> - list of information
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ComponentMapInfo>  findInfoMapAll(){
		
		String emptyPosition = "";
		
		return mapAPIService.findInfoMap(new ComponentMapFilter(emptyPosition, 2017));	
	}
	/**
	 * Method finding filtered informations about regions(count declarations, name region, middle salary of year)
	 * RequestMethod for form - GET
	 *
	 * @param componentMapFilter
	 * @return List<ComponentMapInfo> - list of filtered info 
	 */
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public List<ComponentMapInfo> findInfoMapFilter(@RequestBody ComponentMapFilter componentMapFilter){
		
		return mapAPIService.findInfoMap(componentMapFilter);	
	}
	
}
