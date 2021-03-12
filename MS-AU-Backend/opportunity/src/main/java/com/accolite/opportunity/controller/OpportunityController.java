package com.accolite.opportunity.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunity.dao.Impl.AuditPageImple;
import com.accolite.opportunity.dao.Impl.OpportunityDaoImple;
import com.accolite.opportunity.dao.Impl.UserDaoImple;
import com.accolite.opportunity.model.AuditPage;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.model.User;
@RestController
public class OpportunityController {
	@Autowired
	OpportunityDaoImple opportunityDaoImple;
	
	@Autowired
	AuditPageImple auditPageImple;
	
	@Autowired
	UserDaoImple userDaoImple;
	
	private static final Logger logger = LoggerFactory.getLogger(OpportunityController.class);

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/opportunity/showAll")
    public List<Opportunity> getAllOpportunity(){
        List<Opportunity> opportunityList = new ArrayList<>();
        try {
            opportunityList = opportunityDaoImple.showAllOpportunity();;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return opportunityList;
    }
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path = "/opportunity/search/{column}/{match}")
	@ResponseBody
	public List<Opportunity>  searchBy(@PathVariable("column") String column, @PathVariable("match") String match) {
		
		List<Opportunity> result = null;
		try {
				
				result = opportunityDaoImple.searchOpportunity(column, match);
		}catch(Exception e) {
			logger.error("Opportunity: Data not found ");
		}
		return result;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path = "/opportunity/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int  createOpportunity(@RequestBody Opportunity entry,  @RequestHeader(value = "Email", required=false) String email) {
		
		
		
		User user = userDaoImple.findByEmail(email);
		
		entry.setUserId(user.getUserId());
		return opportunityDaoImple.insert(entry);
	}
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/opportunity/edit/{id}")
	@ResponseBody
	public int  editOpportunity(@PathVariable("id") int id, @RequestBody Opportunity entry) {
		
		return opportunityDaoImple.update(entry);
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/opportunity/delete/{id}")
	@ResponseBody
	public int deleteById(@PathVariable("id") int id) {
		
		return opportunityDaoImple.delete(id);
	}
}
