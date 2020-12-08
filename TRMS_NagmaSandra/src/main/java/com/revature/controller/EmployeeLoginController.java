package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Approvals;
import com.revature.model.Employee;
import com.revature.service.ApprovalService;
import com.revature.service.EmployeeService;

public class EmployeeLoginController {
	static EmployeeService eServ = new EmployeeService();
	
	// Displays Login Page
	public static String login(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/empLogin.html";
			}
	
		// HTML login name variables
		String username = req.getParameter("emp_user");
		String password = req.getParameter("emp_pass");
		

		
		Employee ePerson = eServ.loginGetEmployee(username, password);
		
		if(ePerson==null) {
			return "wrongcreds.change";
		}else {
			req.getSession().setAttribute("currentuser", ePerson);
			System.out.println("LoginController: person: " + ePerson); // JavaScript's http response
			return "home.employee";
		}
	}
}
