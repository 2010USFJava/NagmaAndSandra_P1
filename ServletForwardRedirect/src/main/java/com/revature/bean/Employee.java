package com.revature.bean;

public class Employee {

	private String user;
	private String pass;
	private String first;
	private String last;
	
	
	public Employee() {
		super();
		
	}

	public Employee(String user) {
		super();
		this.user = user;
	}

	public Employee(String user, String pass, String first, String last) {
		super();
		this.user = user;
		this.pass = pass;
		this.first = first;
		this.last = last;
	}
	
	
	
}
