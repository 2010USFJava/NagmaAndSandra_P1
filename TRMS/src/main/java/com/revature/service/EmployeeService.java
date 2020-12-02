package com.revature.service;

import java.util.List;

import com.revature.bean.Employee;

public class EmployeeService {

	//SuperVillainDao svdao = new SuperVillainDao();
	
	
	public boolean loginVerify(String username, String password) {
		
		// List<Employee> employeeList =  svdao.getAllEmployees();
		Employee p1= new Employee("admin","admin");

		boolean verify = false;
		if(p1.getUsername().equals(username)&& p1.getPassword().equals(password)) {
			verify = true;
		}
		return verify;
	
		
	}
	
	public Employee loginGetEmployee(String username, String password) {
		
		Employee p1= new Employee("admin","admin");
		
		if(loginVerify(username,password)) {
			//return svdao.getVillainByName(name);
			System.out.println("login good!!!");
			return p1;
		}
		return null;
	}

}
