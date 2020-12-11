package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.EmployeeService;

public class EmployeeFormController {
	
static EmployeeService eServ = new EmployeeService();
	
//public static String verifyLogin(HttpServletRequest req) {
//		
//
//			//return form(req);
//
//}

public static String formData(HttpServletRequest req) {
	
	if(!req.getMethod().equals("POST")) {
	return "resources/html/emp_form.html";
	}
	
	String  firstName = req.getParameter("n_firstName"); 
	
	System.out.println("EmployeeFormController: formData: " + firstName);
	
	return EmployeeController.employee(req);
	
}

}