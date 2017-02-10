package com.declaration.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.MapComponentDataFilter;
import com.declaration.api.components.entity.MapComponentDeclarations;
import com.declaration.api.components.entity.Response;
import com.declaration.api.components.enums.StatusResponse;
import com.declaration.api.service.MapComponentService;

/**
 * Controller for component map
 * 
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/component/map")
public class MapComponentController {

	@Autowired
	private MapComponentService mapComponentService;

	/**
	 * Method finding filtered informations about regions(count declarations,
	 * name region, salaries and assets of year) RequestMethod for form - POST
	 *
	 * @param mapComponentFilter
	 *            - data for filter
	 * @return List<ComponentMapInfo> - list of filtered info
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Response<MapComponentDeclarations> search(@RequestBody MapComponentDataFilter mapComponentFilter) {

		if (mapComponentFilter.getYearCreate() == null) {

			return new Response<>(StatusResponse.ERROR, "Fields yearCreate is required!!!", null);
		} else {

			return new Response<>(StatusResponse.SUCCESS, "Search is successfull",
					mapComponentService.search(mapComponentFilter));
		}

	}

}
