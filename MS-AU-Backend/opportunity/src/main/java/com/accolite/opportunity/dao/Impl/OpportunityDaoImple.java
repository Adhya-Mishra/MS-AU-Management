package com.accolite.opportunity.dao.Impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.opportunity.dao.OpportunityDao;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.row.OpportunityRow;

@Repository("OpportunityDao")
@Transactional
public class OpportunityDaoImple implements OpportunityDao  {
	
	public OpportunityDaoImple(){}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserDaoImple userDaoImple;

	@Override
	public List<Opportunity>  showAllOpportunity() {
		String SQL = "select * from Opportunity";
        return jdbcTemplate.query(SQL,new OpportunityRow());
	}

	@Override
	public List<Opportunity>  searchOpportunity(String column,String match) {
		List<Opportunity> list = null;
		String query = null;
		if(column.equals("description"))  query = "SELECT * FROM opportunity WHERE description LIKE '%"+match+"%';";
		if(column.equals("location")) query = "SELECT * FROM opportunity  WHERE location LIKE '%"+match+"%';";
		if(column.equals("skills"))  query = "SELECT * FROM opportunity  WHERE skills LIKE '%"+match+"%';";
		if(query != null){
			try {
				list = jdbcTemplate.query(query, new OpportunityRow());
			}catch(Exception e) {
			System.out.print(e.getMessage());
			}
		}
		return list;
	}

	@Override
	public int insert(Opportunity entry) {
		String opportunityInsertion = "INSERT INTO opportunity (description,location, skills, demand, exp, userId,date) VALUES (?, ?, ?, ?, ?, ?, ?);";
		int index = jdbcTemplate.update( opportunityInsertion, new Object[]{entry.getDescription(), entry.getLocation(), entry.getSkills(),  entry.getDemand(), entry.getExp(),entry.getUserId(),entry.getDate()});
		return index;
	}

	@Override
	public int update(Opportunity entry){
		String opportunityUpdate = "UPDATE opportunity SET  description=?,location=?, skills=?, demand=?, exp=?  date=?, WHERE userId=?";
		int index = jdbcTemplate.update(opportunityUpdate, new Object[]{entry.getDescription(), entry.getLocation(), entry.getSkills(), entry.getDemand(), entry.getExp(),entry.getUserId() ,entry.getDate()});
		return index;
	}

	@Override
	public int delete(int id) {
		String opportunityUpdate = "DELETE FROM opportunity WHERE userId =?";
		int index = jdbcTemplate.update(opportunityUpdate, new Object[]{id});
		return index;
	}
	
	
}