package com.revature.model;

public class Employee {
	
	private int eid;
	private String username; 
	private String password;
	private String eFirst;
	private String eLast;
	private String eEmail;
	private int eDepartmentId;
	private int eRole;
	
	public Employee() {
		super();
	}

	public Employee(int eid, String username, String password, String eFirst, String eLast, String eEmail,
			int eDepartmentId, int eRole) {
		super();
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.eFirst = eFirst;
		this.eLast = eLast;
		this.eEmail = eEmail;
		this.eDepartmentId = eDepartmentId;
		this.eRole = eRole;
	}

	public int getId() {
		return eid;
	}

	public void setId(int eid) {
		this.eid = eid;
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

	public String geteFirst() {
		return eFirst;
	}

	public void seteFirst(String eFirst) {
		this.eFirst = eFirst;
	}

	public String geteLast() {
		return eLast;
	}

	public void seteLast(String eLast) {
		this.eLast = eLast;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public int geteDepartmentId() {
		return eDepartmentId;
	}

	public void seteDepartmentId(int eDepartmentId) {
		this.eDepartmentId = eDepartmentId;
	}

	public int geteRole() {
		return eRole;
	}

	public void seteRole(int eRole) {
		this.eRole = eRole;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", username=" + username + ", password=" + password + ", eFirst=" + eFirst
				+ ", eLast=" + eLast + ", eEmail=" + eEmail + ", eDepartmentId=" + eDepartmentId + ", eRole=" + eRole
				+ "]";
	}

	
	


	
}
