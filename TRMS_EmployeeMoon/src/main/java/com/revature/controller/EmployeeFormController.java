package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeFormController {
	
static EmployeeService eServ = new EmployeeService();
	
public static String verifyLogin(HttpServletRequest req) {
		

			return form(req);

}

public static String form(HttpServletRequest req) {
	return "resources/html/emp_form.html";
}

}