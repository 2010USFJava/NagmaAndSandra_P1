package com.revature.service;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.util.LogThis;

public class EmployeeService {
	
	public static EmployeeDao empdao = new EmployeeDaoImpl();
	public List<Employee> empUserList;
	
	public boolean loginVerify(String username, String password){
		
	try {
			
		empUserList = empdao.getEmpUserPass(); 
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	
		boolean verify = false;
		for(Employee ePerson: empUserList) {
			//System.out.println("EmployeeService.java: javascript name: " + username + " " + password); //<-- debug notes  This is where the javascript is coming in
			//System.out.println("EmployeeService.java: sql name: " + ePerson.getUsername() + " " + ePerson.getPassword()); //<-- debug notes  sql names
			if(ePerson.getUsername().equals(username)&& ePerson.getPassword().equals(password)) {
				verify = true;
				LogThis.LogIt("info", "Employee '" + username + "' logged in.");
			}
		}
		return verify;
	}
	
	public Employee loginGetEmployee(String username, String password){
		 
		if(loginVerify(username, password)) {
				System.out.println(" EmployeeService.java: login good :" + username);
				try {
					System.out.println("test");
					return empdao.getEmployeeByName(username); // <-- This is where the database if is pulled
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}
		return null;
	}


}
