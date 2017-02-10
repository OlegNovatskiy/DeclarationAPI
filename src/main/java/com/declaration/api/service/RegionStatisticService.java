package com.declaration.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.declaration.api.components.entity.FilterRegionStatistic;
import com.declaration.api.components.entity.RegionStatistic;
import com.declaration.api.components.interfaces.IRegionStatistic;

/**
 * Service for work with component map
 * @author olegnovatskiy
 */
@Service
public class RegionStatisticService {

	@Autowired
	private IRegionStatistic iRegionStatistic;
			
	/**
	 * Method that will return informations for map component
	 * 
	 * @param filterForMap
	 * @return List<InfoForMap> - list of informations
	 */
	public List<RegionStatistic> search(FilterRegionStatistic mapComponentFilter){
		return iRegionStatistic.search(mapComponentFilter);
	}
	
}
