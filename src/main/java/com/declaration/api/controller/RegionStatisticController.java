package com.declaration.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.FilterRegionStatistic;
import com.declaration.api.components.entity.RegionStatistic;
import com.declaration.api.components.entity.Response;
import com.declaration.api.components.enums.StatusResponse;
import com.declaration.api.service.RegionStatisticService;

/**
 * Controller for region statistic
 * 
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/component/regionStatistic")
public class RegionStatisticController {

	@Autowired
	private RegionStatisticService regionStatisticService;

	/**
	 * Method finding statistic for all regions
	 *  RequestMethod - POST
	 *
	 * @param filterRegionStatistic
	 *            - data for filter
	 * @return List<RegionStatistic> - list of statistics
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Response<RegionStatistic> search(@RequestBody FilterRegionStatistic filterRegionStatistic) {

		if (filterRegionStatistic.getYearCreateDeclaration() == null) {
			Integer codeError = 204;
			
			return new Response<>(codeError, StatusResponse.ERROR, "Fields yearCreateDeclaration is required!!!", null);
		} else {
			Integer codeSuccess = 200;

			return new Response<>(codeSuccess, StatusResponse.SUCCESS, "Search is successfull",
					regionStatisticService.search(filterRegionStatistic));
		}

	}

}
