package com.revature.model;

public class Approvals {
	private int aid; 
	private String type;
	private String username; 
	private String password;
	
	public Approvals() {
		super();
	}
		
	public Approvals(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public Approvals(String type, String username, String password) {
		super();
		this.type = type;
		this.username = username;
		this.password = password;
	}

	public Approvals(int aid, String type, String username, String password) {
		super();
		this.aid = aid;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Approvals [username=" + username + ", password=" + password + ", type=" + type + "]";
	}
	

	

	

}
