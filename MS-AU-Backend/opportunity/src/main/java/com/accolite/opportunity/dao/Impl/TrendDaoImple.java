package com.accolite.opportunity.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("TrendDao")
@Transactional
public class TrendDaoImple {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Map<String, String>> getCountLocation()  {
		String Query="SELECT location, count(*) FROM opportunity GROUP BY location; ";
		List<Map<String,String>> item = new ArrayList<>();
		try {
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
				Collections.sort(item, new Comparator<Map<String, String>>() {

					@Override
					public int compare(Map<String, String> o1, Map<String, String> o2) {
						String v1 = o1.get("name").toLowerCase();
						String v2 = o2.get("name").toLowerCase();
						return v1.compareTo(v2);
					}
					
				});
				
			}
		});
		}catch(Exception e) {
			e.getMessage();
		}
		return item;
	}

	public List<Map<String, String>> getCountSkills()  {
		String Query="SELECT skills, count(*) FROM opportunity GROUP BY skills;";
		List<Map<String,String>> item = new ArrayList<>();
		try {
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
				Collections.sort(item, new Comparator<Map<String, String>>() {

					@Override
					public int compare(Map<String, String> o1, Map<String, String> o2) {
						String v1 = o1.get("name").toLowerCase();
						String v2 = o2.get("name").toLowerCase();
						return v1.compareTo(v2);
					}
					
				});
				
			}
		});
		}catch(Exception e) {
			e.getMessage();
		}
		return item;
	}

	
	

	public List<Map<String, String>> getTotalUser() {
		List<Map<String,String>> item = new ArrayList<>();
		String Query = null;
		try {
		Query="SELECT count(*) FROM user; ";
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
					Map<String,String> temp = new HashMap<>();
					temp.put("name","#Users");
					temp.put("value", resultSet.getString(1));
					item.add(temp);
			}
		});
		
		Query="SELECT COUNT(DISTINCT skills) FROM opportunity; ";
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
			
					Map<String,String> temp = new HashMap<>();
					temp.put("name","#Skills");
					temp.put("value", resultSet.getString(1));
					item.add(temp);
			
			}
		});
		
		Query="SELECT COUNT(*) FROM opportunity; ";
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				
					Map<String,String> temp = new HashMap<>();
					temp.put("name","#Opportunities");
					temp.put("value", resultSet.getString(1));
					item.add(temp);
			
			}
		});
		
		Query="SELECT COUNT(DISTINCT location) FROM opportunity;  ";
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				
					Map<String,String> temp = new HashMap<>();
					temp.put("name","#Locations");
					temp.put("value", resultSet.getString(1));
					item.add(temp);
			
			}
		});
		}catch(Exception e) {
			e.getMessage();
		}
		return item;
	}

}
