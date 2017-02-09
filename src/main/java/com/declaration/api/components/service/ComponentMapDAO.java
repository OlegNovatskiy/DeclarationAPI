package com.declaration.api.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.declaration.api.components.entity.ComponentMapDataFilter;
import com.declaration.api.components.entity.ComponentMapInfo;
import com.declaration.api.components.interfaces.IComponentMap;

/**
 * DAO for map component
 * 
 * @author olegnovatskiy
 */
@Repository
public class ComponentMapDAO implements IComponentMap {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_QUERY = "SELECT si.actual_region AS region, COUNT(ty.id) AS count_declaration, SUM(inc.size_income) AS sum_income_in_region, SUM(inc.size_assets) AS sum_assets_in_region FROM type AS ty INNER JOIN subject_info AS si ON si.id = ty.person_id INNER JOIN income AS inc ON inc.person_id = si.id ";
	private static final String GROUP_BY = " GROUP BY si.actual_region;";

	/**
	 * RowMap for work with selected data from db
	 * 
	 * @author olegnovatskiy
	 */
	public static class ComponentMapRowMap implements RowMapper<ComponentMapInfo> {

		/**
		 * Convert list of date into model
		 */
		@Override
		public ComponentMapInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new ComponentMapInfo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		}

	}

	/**
	 * Method execute select query for finding informations about regions
	 * 
	 * @return List<ComponentMapInfo> - list of info
	 */
	@Override
	public List<ComponentMapInfo> findInfoComponentMap(ComponentMapDataFilter componentMapFilter) {

		StringBuilder queryForSelect = new StringBuilder();
		String conditionPosition = componentMapFilter.getPosition().isEmpty() ? ""
				: String.format(" AND si.work_post = '%s'", componentMapFilter.getPosition());
		String conditionYear = String.format(" WHERE ty.declaration_year = %d ", componentMapFilter.getYearCreate());

		queryForSelect.append(SELECT_QUERY);
		queryForSelect.append(conditionYear);
		queryForSelect.append(conditionPosition);
		queryForSelect.append(GROUP_BY);

		return jdbcTemplate.query(queryForSelect.toString(), new ComponentMapRowMap());
	}

}
