package com.declaration.api.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.declaration.api.components.entity.FilterRegionStatistic;
import com.declaration.api.components.entity.RegionStatistic;
import com.declaration.api.components.interfaces.IRegionStatistic;

/**
 * DAO for map component
 * 
 * @author olegnovatskiy
 */
@Repository
public class RegionStatisticDAO implements IRegionStatistic {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_STATISTICS_REGION_QUERY = "SELECT si.actual_region AS region, COUNT(ty.id) AS count_declaration, SUM(inc.size_income) AS sum_income_in_region, SUM(inc.size_assets) AS sum_assets_in_region FROM type AS ty INNER JOIN subject_info AS si ON si.id = ty.person_id INNER JOIN income AS inc ON inc.person_id = si.id ";
	private static final String GROUP_BY_PER_REGION = " GROUP BY si.actual_region;";

	/**
	 * RowMap for work with selected data from db
	 * 
	 * @author olegnovatskiy
	 */
	public static class MapComponentRowMap implements RowMapper<RegionStatistic> {

		/**
		 * Convert list of date into model
		 */
		@Override
		public RegionStatistic mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new RegionStatistic(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		}

	}

	/**
	 * Method execute select query for finding statistic data a region
	 * 
	 * @return List<ComponentMapInfo> - list of info
	 */
	@Override
	public List<RegionStatistic> search(FilterRegionStatistic filterRegionStatistic) {

		String conditionYear = String.format(" WHERE ty.declaration_year = %d ", filterRegionStatistic.getYearCreateDeclaration());
		StringBuilder queryForSelect = new StringBuilder();
		
		queryForSelect.append(SELECT_STATISTICS_REGION_QUERY);
		queryForSelect.append(conditionYear);
		if(!StringUtils.isBlank(filterRegionStatistic.getPositionDeclarant())){
			queryForSelect.append(String.format(" AND si.work_post = '%s'", filterRegionStatistic.getPositionDeclarant()));
		}		
		queryForSelect.append(GROUP_BY_PER_REGION);

		return jdbcTemplate.query(queryForSelect.toString(), new MapComponentRowMap());
	}

}
