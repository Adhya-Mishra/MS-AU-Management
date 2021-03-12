package com.accolite.opportunity.controller;

import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunity.dao.Impl.TrendDaoImple;

@RestController
public class TrendController {
	@Autowired
	TrendDaoImple trendDaoImple;
	
	private static final Logger logger = LoggerFactory.getLogger(TrendController.class);
	@GetMapping(path = "/trend/totalUser")
	@ResponseBody
	public  List<Map<String, String>> getcountUsers() {	
		logger.info("Total User trend");
		List<Map<String,String>> list = null;
		try {
			list = trendDaoImple.getTotalUser();
		}catch(Exception e) {
			logger.error("Trend :Data not found");
		}
		return list;
	}

	@GetMapping(path = "/trend/location")
	@ResponseBody
	public List<Map<String, String>> getAlllocation() {
		logger.info("Location trend");
		List<Map<String,String>> list = null;
		try {
				list = trendDaoImple.getCountLocation();
		}catch(Exception e) {
			logger.error("Trend: Data not found");
		}
		return list;
	}

	@GetMapping(path = "/trend/skills")
	@ResponseBody
	public  List<Map<String, String>> getAllskills()  {	
		logger.info("Skill trend");
		List<Map<String,String>> list = null;
		try {
			list = trendDaoImple.getCountSkills();
		}catch(Exception e) {
			logger.error("Trend: Data not found");
		}
		return list;
	}

	

	
}
