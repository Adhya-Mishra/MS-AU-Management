package com.accolite.opportunity.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.opportunity.model.User;

public class UserRow implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int row) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		
		user.setName(rs.getString("name"));
		
		user.setGid(rs.getString("gid"));
		
		user.setEmail(rs.getString("email"));
		
		user.setPassword(rs.getString("password"));
	    
		user.setToken(rs.getString("token"));
		
		return user;
	}
}
