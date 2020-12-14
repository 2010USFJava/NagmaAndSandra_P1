package com.revature.model;

public class Approval {
	private int aid; 
	private int role;
	private String username; 
	private String password;
	
	public Approval() {
		super();
	}
		
	public Approval(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public Approval(int role, String username, String password) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
	}

	public Approval(int aid, int role, String username, String password) {
		super();
		this.aid = aid;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Approvals [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	

	

	

}
