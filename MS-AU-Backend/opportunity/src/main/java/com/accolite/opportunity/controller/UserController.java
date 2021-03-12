package com.accolite.opportunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunity.dao.Impl.UserDaoImple;
import com.accolite.opportunity.model.User;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	UserDaoImple userDaoImple;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/user/showAll")
	@ResponseBody
	public Map<Integer,User> retrieveAllUser() {
		
		List<User> list =  userDaoImple.getAllUserList();
		Map<Integer,User> map = new HashMap<>();
		for(User user: list) {
			map.put(user.getUserId(), user);
		}
		return map;	 
	}
	

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/user/getCurrentUser")
	@ResponseBody
	public User currentUser(@RequestHeader(value = "Email", required=false) String email) {
		
		return	userDaoImple.findByEmail(email); 
	}
	

}
