package com.declaration.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.FilterComponentDataFilter;
import com.declaration.api.components.entity.FilterComponentDeclarations;
import com.declaration.api.components.entity.Response;
import com.declaration.api.components.enums.StatusResponse;
import com.declaration.api.service.FilterComponentService;

/**
 * Controller for component filter
 * 
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/component/filter")
public class FilterComponentController {

	@Autowired
	private FilterComponentService filterComponentService;

	/**
	 * Method finding informations for component filter RequestMethod - POST
	 * 
	 * @param componentFilterDataFilter
	 *            - data for filter
	 * @return List<ComponentFilterInfo> - list of information for component
	 *         filter
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Response<FilterComponentDeclarations> search(@RequestBody FilterComponentDataFilter componentFilterDataFilter) {
		if (componentFilterDataFilter.getYearCreate() == null || componentFilterDataFilter.getLimit() == null
				|| componentFilterDataFilter.getPage() == null) {
			
			return new Response<>(StatusResponse.ERROR, "Fields yearCreate, limit and page are required!!!", null);
		} else {
			
			return new Response<>(StatusResponse.SUCCESS, "Search is successfull", filterComponentService.search(componentFilterDataFilter));
		}
	}

}
