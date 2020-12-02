package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.bean.Employee;
import com.revature.service.EmployeeService;

public class LoginController {
	
	static EmployeeService vServ = new EmployeeService();
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/login.html";
			//return "resources/html/approver.benco";
			}
		
		
		String username = req.getParameter("n_user");
		String password = req.getParameter("n_pass");
		Employee e1 = vServ.loginGetEmployee(username, password);
		if(e1==null) {
			return "wrongcreds.change";
		}else {
			req.getSession().setAttribute("currentuser", e1);
			//return "home.change";
			System.out.println(e1);
			return "approver.benco";
		}
	}
	}