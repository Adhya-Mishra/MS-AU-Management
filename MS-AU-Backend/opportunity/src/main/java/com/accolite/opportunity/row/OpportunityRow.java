package com.accolite.opportunity.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.opportunity.model.Opportunity;

public class OpportunityRow implements RowMapper<Opportunity>{
	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Opportunity opportunity = new Opportunity();
        opportunity.setOpportunityId(rs.getInt("opportunityId"));
        
        opportunity.setDescription(rs.getString("description"));
        
        opportunity.setLocation(rs.getString("location"));
        
        opportunity.setSkills(rs.getString("skills"));
     
        
        opportunity.setExp(rs.getInt("exp"));
        
        opportunity.setDemand(rs.getInt("demand"));
        
        opportunity.setUserId(rs.getInt("userId"));
        
        opportunity.setDate(rs.getDate("date"));
        return opportunity;
    }
}
