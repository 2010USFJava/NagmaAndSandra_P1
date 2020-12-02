package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.ApprovalController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {

public static String process(HttpServletRequest req) {
		
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
			
		case "/TRMS/login.change":
			System.out.println("in login.change rhelper");
			return LoginController.login(req);
			
		case "/TRMS/home.change":
			System.out.println("in home.change rhelper");
			return HomeController.home(req);
			
		case "/TRMS/approver.benco":
			System.out.println("in approver.benco rhelper");
			return ApprovalController.approval(req);
			
		default:
			System.out.println("in default case");
			return "resources/html/failure.html";
			
		}
		
	}
}
