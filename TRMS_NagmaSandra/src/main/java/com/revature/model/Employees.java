package com.revature.model;

public class Employees {
	
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public Employees() {
		super();
	}
	public Employees(int id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Employees [id =" + id + ", username =" + username + ", password =" + password + ", firstName =" + firstName
				+ ", lastName =" + lastName + "]";
	}
	
	
}
