 package com.declarationapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declarationapi.components.entity.ComponentMapFilter;
import com.declarationapi.components.entity.ComponentMapInfo;
import com.declarationapi.service.ComponentMapAPIService;

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
	 * @return List<InfoForMap> - list of information
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ComponentMapInfo>  findAllInfoForMap(){
		
		String emptyPosition = "";
		
		return mapAPIService.findInfoForMap(new ComponentMapFilter(emptyPosition, 2017));	
	}
	/**
	 * Method finding filtered informations about regions(count declarations, name region, middle salary of year)
	 * RequestMethod for form - GET
	 *
	 * @param filterForMap
	 * @return List<InfoForMap> - list of filtered info 
	 */
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public List<ComponentMapInfo> findWithFilterInfoForMap(@RequestBody ComponentMapFilter filterForMap){
		
		return mapAPIService.findInfoForMap(filterForMap);	
	}
	
}
