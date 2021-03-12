package com.accolite.opportunity.dao.Impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.opportunity.dao.UserDao;
import com.accolite.opportunity.model.User;
import com.accolite.opportunity.row.UserRow;

@Repository("UserDao")
@Transactional
public class UserDaoImple implements UserDao {
public UserDaoImple(){}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUserList() {
		List<User> list = jdbcTemplate.query("SELECT * FROM user", new UserRow());
		Collections.reverse(list);
		return list;
	}

	@Override
	public int insertUser(User u, String token) {
		String insertSql = "INSERT INTO user (email, gid, name, password, token) VALUES (?,?,?,?,?)";
 		int a =  jdbcTemplate.update(insertSql, new Object[]{u.getEmail(),u.getGid(),u.getName(),u.getPassword(),token});
 		return a;
	}

	@Override
	public int updateToken(User u, String token) {
		String updateSql = "UPDATE user SET  token='"+token+"' WHERE userid="+String.valueOf(u.getUserId());
 		return jdbcTemplate.update(updateSql);	
	}

	@Override
	public User findByEmail(String email) {
		User u = null;
		
		try {
			
		u = jdbcTemplate.queryForObject("SELECT * FROM user WHERE email='"+email+"';", new UserRow());
		System.out.println(u);
		}catch(Exception e) {

		}
		return u;
	}

}
