package com.accolite.opportunity.dao;

import java.util.List;

import com.accolite.opportunity.model.AuditPage;

public interface AuditPageDao {
	public int insertAudit(AuditPage entry, String email);
	
public List<AuditPage> showAllAudit() throws Exception;
	
	public List<AuditPage> searchAudit(String column, String match) throws Exception;
}
