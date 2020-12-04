package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Approvals;
import com.revature.service.ApprovalService;
import com.revature.service.EmployeeService;

public class LoginController {
	
	static EmployeeService eServ = new EmployeeService();
	static ApprovalService aServ = new ApprovalService();
	
	// Displays Login Page
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/login.html";
			}
	
		// HTML login name variables
		String username = req.getParameter("n_user");
		String password = req.getParameter("n_pass");
		
		
		//Employees ePerson = eServ.loginGetEmployee(username, password);
		Approvals aPerson = aServ.loginGetApproval(username, password);
		
		
		if(aPerson==null) {
			return "wrongcreds.change";
		}else {
			req.getSession().setAttribute("currentuser", aPerson);
			System.out.println("LoginController: person: " + aPerson); // JavaScript's http response
			return "approver.benco";
		}
	}
}
