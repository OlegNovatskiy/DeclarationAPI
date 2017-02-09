package com.declaration.api.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.declaration.api.components.entity.ComponentFilterDataFilter;
import com.declaration.api.components.entity.ComponentFilterInfo;
import com.declaration.api.components.interfaces.IComponentFilter;

/**
 * Service for component filter
 * 
 * @author olegnovatskiy
 */
@Repository
public class ComponentFilterDAO implements IComponentFilter {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_QUERY = "SELECT ty.declaration_id, si.first_name, si.last_name, si.middle_name, si.work_post, si.actual_region FROM type as ty INNER JOIN subject_info AS si ON ty.person_id = si.id";
	private Boolean useAndMYSQLWord;

	/**
	 * Map for work with selected data from db
	 * 
	 * @author olegnovatskiy
	 */
	public static class ComponentFilterRowMap implements RowMapper<ComponentFilterInfo> {
		/**
		 * Convert list of date into model
		 */
		@Override
		public ComponentFilterInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new ComponentFilterInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6));
		}

	}

	/**
	 * Method find informations for component filter
	 * 
	 * @param componentFilterDataFilter
	 *            - data for filter
	 * @return List<ComponentFilterInfo> - find informations for filter
	 *         component
	 */
	@Override
	public List<ComponentFilterInfo> findInfoComponentFilter(ComponentFilterDataFilter componentFilterDataFilter) {

		String limit = componentFilterDataFilter.getLimit() >= 1
				? String.format(" LIMIT %d", componentFilterDataFilter.getLimit()) : " LIMIT 10";
		Integer offset = componentFilterDataFilter.getPage() >= 1
				? componentFilterDataFilter.getLimit() * (componentFilterDataFilter.getPage() - 1) : 0;
		String page = String.format(" OFFSET %d;", offset);
		StringBuilder selectQuery = new StringBuilder();
		useAndMYSQLWord = false;

		selectQuery.append(SELECT_QUERY);

		if (componentFilterDataFilter.getYearCreate() > 1901) {
			selectQuery.append(
					String.format(" WHERE ty.declaration_year = %d", componentFilterDataFilter.getYearCreate()));
			useAndMYSQLWord = true;
		}
		addCondition(selectQuery, "si.actual_region", componentFilterDataFilter.getLocation());
		addCondition(selectQuery, "si.first_name", componentFilterDataFilter.getFirstName());
		addCondition(selectQuery, "si.last_name", componentFilterDataFilter.getLastName());
		addCondition(selectQuery, "si.middle_name", componentFilterDataFilter.getMiddleName());
		addCondition(selectQuery, "si.work_post", componentFilterDataFilter.getPosition());
		selectQuery.append(limit);
		selectQuery.append(page);

		return jdbcTemplate.query(selectQuery.toString(), new ComponentFilterRowMap());
	}

	/**
	 * Method add conditions to query
	 * 
	 * @param query
	 *            - StringBuilder for create query in db
	 * @param addedField
	 *            - Field that will added to conditions
	 * @param value
	 *            - Value for field
	 * @param useAnd
	 *            - Status of mysql word 'AND'(use or no)
	 * @return boolean status of mysql word 'AND'
	 */
	private void addCondition(StringBuilder query, String addedField, String value) {
		if (!value.isEmpty()) {
			if (useAndMYSQLWord) {
				query.append(String.format(" AND %s = '%s'", addedField, value));
			} else {
				query.append(String.format(" WHERE %s = '%s'", addedField, value));
				useAndMYSQLWord = true;
			}
		}
	}

}
