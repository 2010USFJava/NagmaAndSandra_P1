package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {

public static String process(HttpServletRequest req) {
		
	//String projectName = "TRMS_NagmaSandra";
	
		System.out.println("RequestHelper.java : " + req.getRequestURI());
		switch(req.getRequestURI()) {
			
		case "/TRMS_NagmaSandra/login.change": /* This case will display 'login' page for all users */
			System.out.println("RequestHelp.java : in login.change rhelper");
			return LoginController.login(req);
			
		case "/TRMS_NagmaSandra/home.change": /* This case will display 'home' pages */
			System.out.println("RequestHelp.java : in home.change rhelper");
			return HomeController.home(req);
			
//		case "/TRMS_NagmaSandra/approval": /* This case will display 'approvers(1-5)' pages */
//			System.out.println("RequestHelper.java : in approver.role rhelper");
//			return ApprovalController.approval(req);
			
		default:
			System.out.println("RequestHelp.java : in default case Check RequestHelper.java"); /* 'failure' page displayed */
			return "resources/html/failure.html";
			
		}
		
	}
}
