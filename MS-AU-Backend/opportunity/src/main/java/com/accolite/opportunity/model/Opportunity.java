package com.accolite.opportunity.model;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Opportunity {

	private int opportunityId;
	private String description;
	private String location;
	private String skills;
	private int exp;
	private int demand;
	private int userId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	 
	public Opportunity(int opportunityId, String description, String location, String skills, int exp, int demand,
			int userId, Date date) {
		
		this.opportunityId = opportunityId;
		this.description = description;
		this.location = location;
		this.skills = skills;
		this.exp = exp;
		this.demand = demand;
		this.userId = userId;
		this.date= date;
	}
	public Opportunity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Opportunity [opportunityId=" + opportunityId + ", description=" + description + ", location=" + location
				+ ", skills=" + skills + ", exp=" + exp + ", demand=" + demand + ", userId=" + userId + ", date=" + 
				 "]";
	}
	public int getOpportunityId() {
		return opportunityId;
	}
	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getDemand() {
		return demand;
	}
	public void setDemand(int demand) {
		this.demand = demand;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
	this.date=date;
		
	}
	
}
	
	
	
	

