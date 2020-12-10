package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeInfoController {
	public static String info(HttpServletRequest req, HttpServletResponse res) {
	System.out.println("-----EMPLOYEE INFO CONTROLLER----");
	String cookie_user = null;
	Cookie[] cookies = req.getCookies();
	
	if(cookies !=null){
		for(int i=0;i<cookies.length;i++){ 
		if(cookies[i].getName().equals("user")) {cookie_user = cookies[i].getValue();
		System.out.println(cookies[i].getName().equals("user")); //boolean validates function
		System.out.println("EmpLoginController:" + cookie_user);
		}}}
		if(cookie_user !=null) {
//			Cookie logoutCookie = null;
//			logoutCookie = new Cookie("user", "");
//			logoutCookie.setMaxAge(0);
//			res.addCookie(logoutCookie);

			return "resources/html/employee.html";
			}
				
				return EmployeeLoginController.login(req, res);
	}
	}
