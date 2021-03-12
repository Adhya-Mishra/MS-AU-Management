package com.accolite.opportunity.dao;

import java.util.List;
import java.util.Map;

public interface TrendDao {
	public List<Map<String,String>> getTotalUser();
public List<Map<String,String>> getCountLocation() ;
	
	public List<Map<String,String>> getCountSkills() ;
	
	public List<Map<String,String>> getCountDemand() ;
	
	public List<Map<String,String>> getCountExp() ;
	
	
}
