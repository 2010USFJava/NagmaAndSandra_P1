package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController {
	public static String employee(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("-----EMPLOYEE HOME CONTROLLER----");
		return "resources/html/employee.html";
		
	}
	
}

			


	
