package com.declaration.api.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.declaration.api.components.entity.FilterComponentDataFilter;
import com.declaration.api.components.entity.FilterComponentDeclarations;
import com.declaration.api.components.interfaces.IFilterComponent;

/**
 * Service for component filter
 * 
 * @author olegnovatskiy
 */
@Repository
public class FilterComponentDAO implements IFilterComponent {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_DECLARATIONS_QUERY = "SELECT ty.declaration_id, si.first_name, si.last_name, si.middle_name, si.work_post, si.actual_region FROM type as ty INNER JOIN subject_info AS si ON ty.person_id = si.id";

	/**
	 * Map for work with selected data from db
	 * 
	 * @author olegnovatskiy
	 */
	public static class FilterComponentRowMap implements RowMapper<FilterComponentDeclarations> {
		/**
		 * Convert list of date into model
		 */
		@Override
		public FilterComponentDeclarations mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new FilterComponentDeclarations(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
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
	public List<FilterComponentDeclarations> search(FilterComponentDataFilter componentFilterDataFilter) {

		String limit = String.format(" LIMIT %d", componentFilterDataFilter.getLimit());
		Integer offset = componentFilterDataFilter.getLimit() * (componentFilterDataFilter.getPage() - 1);
		String page = String.format(" OFFSET %d;", offset);
		
		StringBuilder selectQuery = new StringBuilder();

		selectQuery.append(SELECT_DECLARATIONS_QUERY);
		selectQuery.append(String.format(" WHERE ty.declaration_year = %d", componentFilterDataFilter.getYearCreate()));
		addCondition(selectQuery, "si.actual_region", componentFilterDataFilter.getLocation());
		addCondition(selectQuery, "si.first_name", componentFilterDataFilter.getFirstName());
		addCondition(selectQuery, "si.last_name", componentFilterDataFilter.getLastName());
		addCondition(selectQuery, "si.middle_name", componentFilterDataFilter.getMiddleName());
		addCondition(selectQuery, "si.work_post", componentFilterDataFilter.getPosition());
		selectQuery.append(limit);
		selectQuery.append(page);

		return jdbcTemplate.query(selectQuery.toString(), new FilterComponentRowMap());
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
		if (!StringUtils.isBlank(value)) {
				query.append(String.format(" AND %s = '%s'", addedField, value));
		}
	}

}
