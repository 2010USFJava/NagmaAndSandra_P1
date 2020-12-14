package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Approval;
import com.revature.service.ApprovalService;

public class ApprovalLoginController {
	
	static ApprovalService aServ = new ApprovalService();
	
	// Displays Login Page
	public static String login(HttpServletRequest req) {
		
		/*  [Step 1] If not equal to 'POST' show Login Page*/
		if(!req.getMethod().equals("POST")) {
			return "resources/html/app_login.html";
			}
		
		/*  [Step 2] Store user input from form into java variables
		 *		- HTML login name variables n_user, n_pass
		 *  	- javascript is coming from the req methods
		 */	
		String username = req.getParameter("n_app_user"); 
		String password = req.getParameter("n_app_pass");
		
		/*  [Step 3] Compare database info with user input */
		Approval aPerson = aServ.loginGetApproval(username, password);
		
		
		if(aPerson==null) {
			return "wrongcreds.change";
		}else {
			int role = getApprovalRole(aPerson.getUsername());
			aPerson.setRole(role);
			
			System.out.println("LoginController: person: " + aPerson); 
			System.out.println("LoginController: role: " + role);
			
			req.getSession().setAttribute("currentuser", aPerson);
			req.getSession().setAttribute("currentrole", role);
			
			//String page = "approval";
			//return page;
			return ApprovalController.approval(req);
		}
	}
	
	// Will move later
	// Role should be called from the database but hard coding for now
	public static int getApprovalRole(String username){
		int role = 0;
		
		if(username.equals("benco")) { 
			role = 1;
			return role;
		}
		if(username.equals("dirsup")) { 
			role = 2;
			return role;
		}
		if(username.equals("dirhead")) { 
			role = 3;
			return role;
		}
		if(username.equals("mgmt")) { 
			role = 4;
			return role;
		}
		if(username.equals("dirmgmt")) { 
			role = 5;
			return role;
		}
		else
			System.out.println("LoginController: else, role: " + role);
			System.out.println("LoginController: else, username: " + username);
			return role;
			
		
	}
	
	
	
	
}
