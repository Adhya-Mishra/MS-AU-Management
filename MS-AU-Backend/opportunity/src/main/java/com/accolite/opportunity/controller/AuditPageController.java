package com.accolite.opportunity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.opportunity.dao.Impl.AuditPageImple;
import com.accolite.opportunity.model.AuditPage;

public class AuditPageController {

    @Autowired
    AuditPageImple auditPageImple;
    
    private static final Logger logger = LoggerFactory.getLogger(AuditPageController.class);
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/audit/getAll")
    @ResponseBody
    public List<AuditPage> getAllAudit() {
  	  	logger.info("Show all Audits");
  	  	List<AuditPage> list = null;
  	  	try {
  	  		list = auditPageImple.showAllAudit();
  	  	}catch(Exception e) {
  	  		logger.error("Audit: Data not found");
  	  	}
  	  	return list;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/audit/search/{column}/{match}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<AuditPage> searchBy(@PathVariable("column") String column, @PathVariable("match") String match) {
  	  	logger.info("Search audit");
  	  	List<AuditPage> list = null;
  	  	try {
  	  		list = auditPageImple.searchAudit(column, match);
  	  	}catch(Exception e) {
  	  		logger.error("Audit:Data not found");
  	  	}
  	  	return list;
    }
}
