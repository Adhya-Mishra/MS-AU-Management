package com.accolite.opportunity.dao.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.accolite.opportunity.dao.AuditPageDao;
import com.accolite.opportunity.model.AuditPage;
import com.accolite.opportunity.model.User;
import com.accolite.opportunity.row.AuditRow;
@Service
public class AuditPageImple implements AuditPageDao{

	public AuditPageImple(){}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserDaoImple userDaoImple;
	
	@Override
	public List<AuditPage> showAllAudit() throws Exception {
		List<AuditPage> list = new ArrayList<>();
		try {
			list = jdbcTemplate.query("SELECT * FROM audit", new AuditRow());
			Collections.reverse(list);
		}catch(Exception e) {
			e.getMessage();
		}
		return list;
	}

	@Override
	public int insertAudit(AuditPage entry, String email) {
		User user = userDaoImple.findByEmail(email);
		String insertSQL = "INSERT INTO audit (date, operation,previous, updated, userId) VALUES (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(insertSQL, new Object[]{entry.getDate(), entry.getOperation(), entry.getPrevious(),entry.getUpdated(),user.getUserId()}); 
		return result;
	}

	@Override
	public List<AuditPage> searchAudit(String col, String place)  {
		List<AuditPage> list = null;
		String query = null;
		if(col.equals("date"))  query = "SELECT * FROM auditpage WHERE date LIKE '%"+place+"%';"; 
		else if(col.equals("operation")) query = "SELECT * FROM auditpage  WHERE operation LIKE '%"+place+"%';";
		else if(col.equals("userid"))  query = "SELECT * FROM auditpage  WHERE user_id LIKE '%"+place+"%';";
		
		
		else query = null;
		if(query != null) {
			try {
				list = jdbcTemplate.query(query, new AuditRow());
			}catch(Exception e) {
				e.getMessage();
			}
		}
		return list;
	}

	
	

}
