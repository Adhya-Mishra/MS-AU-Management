package com.accolite.opportunity.dao;

import java.util.List;

import com.accolite.opportunity.model.Opportunity;

public interface OpportunityDao {
	public List<Opportunity> showAllOpportunity();
	
	public List<Opportunity> searchOpportunity(String column,String match);
	
	public int insert(Opportunity entry);
	
	public int update(Opportunity entry);
	
	public int delete(int id);

	
	 
}
