package com.accolite.opportunity.dao;

import java.util.List;

import com.accolite.opportunity.model.User;

public interface UserDao {
	public List<User> getAllUserList();
	
	public User findByEmail(String email);

	public int updateToken(User user, String token);
	int insertUser(User user, String token);
}
