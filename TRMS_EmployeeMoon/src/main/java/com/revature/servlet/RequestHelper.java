package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.ApprovalLoginController;
import com.revature.controller.EmployeeController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.EmployeeHistoryController;
import com.revature.controller.EmployeeHistoryController2;
import com.revature.controller.EmployeeInfoController;
import com.revature.controller.EmployeeLoginController;
import com.revature.controller.EmployeeStatusController;
import com.revature.controller.HomeController;
import com.revature.controller.LogoutController;
import com.revature.controller.EmpolyeeLogoutController;


public class RequestHelper {

public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
	//String projectName = "TRMS_EmployeeMoon";
		System.out.println("RequestHelper.java : " + req.getRequestURI());
		switch(req.getRequestURI()) {
			
		case "/TRMS_EmployeeMoon/home": /* This case will display 'home' pages */
			System.out.println("RequestHelp.java : in /home rhelper");
			return HomeController.home(req, res);
			
		case "/TRMS_EmployeeMoon/employeelogin": /* This case will display 'login' page for all users */
			System.out.println("in /employeelogin rhelper");
			return EmployeeLoginController.login(req, res);	
			
		case "/TRMS_EmployeeMoon/approvallogin": /* This case will display 'login' page for all users */
			System.out.println("RequestHelp.java : in /approvallogin rhelper");
			return ApprovalLoginController.login(req);
		
//		case "/TRMS_EmployeeMoon/employeehome": /* */
//				System.out.println("in /employeehome rhelper");
//			return EmployeeController.employee(req, res);
		
		case "/TRMS_EmployeeMoon/employeeinfo": /* */
			System.out.println("in /employeeinfo rhelper");
		return EmployeeInfoController.info(req, res);
		
		case "/TRMS_EmployeeMoon/employeelogout": /* */
			System.out.println("in /employeelogout rhelper");
		return EmpolyeeLogoutController.logout(req, res);
	
		case "/TRMS_EmployeeMoon/employeestatus": /* */
			System.out.println("in /employeestatus rhelper");
			return EmployeeStatusController.status(req, res);

		case "/TRMS_EmployeeMoon/employeehistory": /*  */
			System.out.println("in /employeehistory rhelper");
			return EmployeeHistoryController.history(req, res);
			
		case "/TRMS_EmployeeMoon/employeeform": /*  */
			System.out.println("in /employeeform rhelper");
			return EmployeeFormController.form(req, res);
			
		case "/TRMS_EmployeeMoon/logout": /* */
			System.out.println("in /logout rhelper");
		return LogoutController.logout(req, res);
			
		case "TRMS_EmployeeMoon/failure":
			System.out.println("RequestHelp.java : in default case Check RequestHelper.java"); /* 'failure' page displayed */
			return "resources/html/failure.html";
			
		default:
			System.out.println("RequestHelp.java : in default case Check RequestHelper.java"); /* 'failure' page displayed */
			return "resources/html/failure.html";
			
		}
		
	}
}