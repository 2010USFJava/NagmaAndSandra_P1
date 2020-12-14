package com.revature.controller;


import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeLoginController {
	
	
static EmployeeService eServ = new EmployeeService();

	
	// Displays Login Page
	public static String login(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("-----EMPLOYEE LOGIN CONTROLLER----");
		if(!req.getMethod().equals("POST")) {
			return "resources/html/emp_login.html";
			}
	
		// HTML login name variables
		String username = req.getParameter("n_emp_user");
		String password = req.getParameter("n_emp_pass");
		
		
		Employee ePerson = eServ.loginGetEmployee(username, password);
		
		if(ePerson==null) {
			return "failure";
		}else {
			Cookie logoutCookie = null;
			logoutCookie = new Cookie("user", "");
			logoutCookie.setMaxAge(0);
			res.addCookie(logoutCookie);
			Cookie logoutSession = null;
			logoutSession = new Cookie("JSESSIONID", "");
			logoutSession.setMaxAge(0);
			res.addCookie(logoutSession);
			
			HttpSession session = req.getSession();
			session.setAttribute("currentuser", ePerson.getUsername());
			Cookie loginCookie = null;
			loginCookie = new Cookie("user", ePerson.getUsername());
			loginCookie.setMaxAge(15*60);
			res.addCookie(loginCookie);
			String cookie_user = null;
			Cookie[] cookies = req.getCookies();
			
			if(cookies !=null){
				for(int i=0;i<cookies.length;i++){ 
				if(cookies[i].getName().equals("user")) {cookie_user = cookies[i].getValue();
				System.out.println(cookies[i].getName().equals("user")); //boolean validates function
				System.out.println("EmpLoginController:" + cookie_user);
				
				}}}
			System.out.println("EmpLoginController Cookie:" + cookie_user);
			System.out.println(session.getAttribute("currentuser"));
			System.out.println("EmpLoginController: person: " + ePerson); // JavaScript's http response
			return EmployeeController.employee(req, res);
		}
	}

} 
