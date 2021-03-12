package com.accolite.opportunity.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.opportunity.model.AuditPage;

public class AuditRow implements RowMapper<AuditPage> {

	@Override
	public AuditPage mapRow(ResultSet rs, int rowNum) throws SQLException {
		AuditPage audit = new AuditPage();
		audit.setId(rs.getInt("id"));
		audit.setDate(rs.getString("date"));
		audit.setOperation(rs.getString("operation"));
		audit.setPrevious(rs.getString("previous"));
		audit.setUpdated(rs.getString("updated"));
		audit.setUserId(rs.getInt("userId"));
		
		return audit;
	}
}
