package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.ApprovalLoginController;
import com.revature.controller.EmployeeLoginController;
import com.revature.controller.HomeController;

public class RequestHelper {

public static String process(HttpServletRequest req) {
		
	//String projectName = "TRMS_NagmaSandra";
	
		System.out.println("RequestHelper.java : " + req.getRequestURI());
		switch(req.getRequestURI()) {
			
		case "/TRMS_EmployeeMoon/home": /* This case will display 'home' pages */
			System.out.println("RequestHelp.java : in home.change rhelper");
			return HomeController.home(req);
			
		case "/TRMS_EmployeeMoon/employeelogin": /* This case will display 'login' page for all users */
			System.out.println("in empLogin.change rhelper");
			return EmployeeLoginController.login(req);	
			
		case "/TRMS_EmployeeMoon/approvallogin": /* This case will display 'login' page for all users */
			System.out.println("RequestHelp.java : in login.change rhelper");
			return ApprovalLoginController.login(req);
		
			
		default:
			System.out.println("RequestHelp.java : in default case Check RequestHelper.java"); /* 'failure' page displayed */
			return "resources/html/failure.html";
			
		}
		
	}
}
