package com.revature.model;

import java.util.ArrayList;

public class Employee {
	
	private int id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private int departmentId;
	private int role;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Employee(Employee e) {
		this.id =e.id;
		this.email = e.email;
		this.password =e.password;
		this.firstname = e.firstname;
		this.lastname = e.lastname;
		this.departmentId = e.departmentId;
		this.role =e.role;
	}

	public Employee(int id, String email, String password, String firstname, String lastname, int departmentId,
			int role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.departmentId = departmentId;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", departmentId=" + departmentId + ", role=" + role + "]";
	}
}
