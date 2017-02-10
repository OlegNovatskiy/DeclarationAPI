package com.declaration.api.components.interfaces;

import java.util.List;

import com.declaration.api.components.entity.FilterRegionStatistic;
import com.declaration.api.components.entity.RegionStatistic;

/**
 * Interface for work with region statistic
 *
 * @author olegnovatskiy
 */
@FunctionalInterface
public interface IRegionStatistic {
	
	/**
	 * Method find statistic a region
	 * 
	 * @param filterForMap - filter for search
	 * @return List<RegionStatistic> - informations for map component
	 */
	public List<RegionStatistic> search(FilterRegionStatistic filterRegionStatistic);
	
}
