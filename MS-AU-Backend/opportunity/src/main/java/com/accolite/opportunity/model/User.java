package com.accolite.opportunity.model;

public class User {
	private int userId;

	private String name;

	private String email;
	private String password;
	private String gid;
	private String token;
	

	public User() {
		
	}
	public User(int userId, String name, String email, String password, String gid, String token) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gid = gid;
		this.token = token;
	}
	
	public User(String name, String email, String password, String gid, String token) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gid = gid;
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGid() {
		return gid;
	}


	public void setGid(String i) {
		this.gid = i;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	@Override
	public String toString() {
		return "User [userid=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", gid="
				+ gid +  "]";
	}
	

}