package com.revature.controller;


import javax.servlet.http.HttpServletRequest;


import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeLoginController {
	
static EmployeeService eServ = new EmployeeService();
	
	// Displays Login Page
	public static String login(HttpServletRequest req){
		if(!req.getMethod().equals("POST")) {
			return "resources/html/emp_login.html";
			}
	
		// HTML login name variables
		String username = req.getParameter("n_emp_user");
		String password = req.getParameter("n_emp_pass");
		

		Employee ePerson = eServ.loginGetEmployee(username, password);
		
		if(ePerson==null) {
			return "wrongcreds.change";
		}else {
			req.getSession().setAttribute("currentuser", ePerson);
			System.out.println("LoginController: person: " + ePerson); // JavaScript's http response
			//return "/employeehome";
			return EmployeeController.employee(req);
		}
	}

}
