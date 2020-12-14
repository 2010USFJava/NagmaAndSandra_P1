package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.ApprovalController;
import com.revature.controller.ApprovalLoginController;
import com.revature.controller.EmployeeController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.EmployeeHistoryController;
import com.revature.controller.EmployeeLoginController;
import com.revature.controller.EmployeeStatusController;
import com.revature.controller.HomeController;


public class RequestHelper {

public static String process(HttpServletRequest req) {
		
	//String projectName = "TRMS_NagmaSandra";
	
		System.out.println("RequestHelper.java : " + req.getRequestURI());
		switch(req.getRequestURI()) {
			
		case "/TRMS_EmployeeMoon/home": /* This case will display 'home' pages */
			System.out.println("RequestHelp.java : in /home rhelper");
			return HomeController.home(req);
			
		case "/TRMS_EmployeeMoon/employeelogin": /* This case will display 'login' page for all users */
			System.out.println("in /employeelogin rhelper");
			return EmployeeLoginController.login(req);	
			
		case "/TRMS_EmployeeMoon/approvallogin": /* This case will display 'login' page for all users */
			System.out.println("RequestHelp.java : in /approvallogin rhelper");
			return ApprovalLoginController.login(req);
			
		case "/TRMS_EmployeeMoon/approvalhome": /* This case will display 'login' page for all users */
			System.out.println("RequestHelp.java : in /approvalhome rhelper");
			return ApprovalController.formData(req);
			
		case "/TRMS_EmployeeMoon/approvalmgmt": /* mgmt handles form */
			System.out.println("RequestHelp.java : in /approvalmgmt formMgmt");
			return ApprovalController.formMgmt(req);
			
		case "/TRMS_EmployeeMoon/approvaldirmgmt": /* dirmgmt handles form */
			System.out.println("RequestHelp.java : in /approvaldirmgmt dirmgmt");
			return ApprovalController.dirMgmt(req);	
		
		case "/TRMS_EmployeeMoon/approvaldirsup": /* dirsup handles form*/
			System.out.println("RequestHelp.java : in /approvaldirsup dirsup");
			return ApprovalController.dirSup(req);	
		
		case "/TRMS_EmployeeMoon/approvaldepthead": /* depthead handles form */
			System.out.println("RequestHelp.java : in /approvaldirhead dirsup");
			return ApprovalController.deptHead(req);
			
		case "/TRMS_EmployeeMoon/approvalbenco": /* benco handle form */
			System.out.println("RequestHelp.java : in /approvalbenco dirsup");
			return ApprovalController.benco(req);	
			
		case "/TRMS_EmployeeMoon/employeehome": /* */
			System.out.println("in /employeehome rhelper");
			return EmployeeController.employee(req);
			
		case "/TRMS_EmployeeMoon/employeestatus": /* */
				System.out.println("in /employeestatus rhelper");
				return EmployeeStatusController.status(req);
				
		case "/TRMS_EmployeeMoon/employeehistory": /*  */
			System.out.println("in /employeehistory rhelper");
			return EmployeeHistoryController.history(req);
			
		case "/TRMS_EmployeeMoon/employeeform": /*  */
			System.out.println("in /employeeform rhelper");
			//EmployeeLoginController.loginVerified();
			return EmployeeFormController.formData(req);	
			
		default:
			System.out.println("RequestHelp.java : in default case Check RequestHelper.java"); /* 'failure' page displayed */
			return "resources/html/failure.html";
			
		}
		
	}
}
