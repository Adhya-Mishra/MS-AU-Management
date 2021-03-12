package com.accolite.opportunity.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AuditPage {
	int id;
    String date;
	String operation;
	String previous;
	String updated;
    int userId;
	public int getId() {
		return id;
	}

	public AuditPage(int id, String date, String operation, String previous, String updated, int userId) {
		super();
		this.id = id;
		Calendar.getInstance();

		this.date =  new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		this.operation = operation;
		this.previous = previous;
		this.updated = updated;
		this.userId = userId;
	}

	public void setId(int id) {
		this.id = id;
	}
	public AuditPage() {}
	public AuditPage(String date, String operation, String previous, String updated) {
		super();
		Calendar.getInstance();
		this.date =  new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		this.operation = operation;
		this.previous = previous;
		this.updated = updated;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
