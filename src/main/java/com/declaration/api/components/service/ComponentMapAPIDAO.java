package com.declaration.api.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.declaration.api.components.entity.ComponentMapFilter;
import com.declaration.api.components.entity.ComponentMapInfo;
import com.declaration.api.components.interfaces.IComponentMapAPI;

/**
 * DAO for map API
 * 
 * @author olegnovatskiy
 */
@Repository
public class ComponentMapAPIDAO implements IComponentMapAPI {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * My map for work with selected data from db
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
	public List<ComponentMapInfo> findInfoMap(ComponentMapFilter componentMapFilter) {

		final StringBuilder queryForSelect = new StringBuilder();
		queryForSelect.append(" SELECT");
		queryForSelect.append(" si.actual_region AS region,");
		queryForSelect.append(" COUNT(ty.id) AS count_declaration,");
		queryForSelect.append(" SUM(inc.size_income) AS sum_income_in_region,");
		queryForSelect.append(" SUM(inc.size_assets) AS sum_assets_in_region");		
		queryForSelect.append("	FROM type AS ty");
		queryForSelect.append(" INNER JOIN subject_info AS si ON si.id = ty.person_id");
		queryForSelect.append(" INNER JOIN income AS inc ON inc.person_id = si.id");
		queryForSelect.append(String.format(" WHERE ty.declaration_year = %d",componentMapFilter.getYearCreateDeclaration()));
		queryForSelect.append( componentMapFilter.getPositionDeclarant().isEmpty() ? "" : String.format(" AND si.work_post = '%s'", componentMapFilter.getPositionDeclarant()));
		queryForSelect.append(" GROUP BY si.actual_region;");

		return jdbcTemplate.query(queryForSelect.toString(), new ComponentMapRowMap());
	}

}
