package com.revature.model;

public class Approvals {
	
	private String username; 
	private String password;
	private String type;
	
	public Approvals() {
		super();
	}
		
	public Approvals(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Approvals(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
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
