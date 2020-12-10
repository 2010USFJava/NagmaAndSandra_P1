package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeFormController {
	public static String form(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("-----FORM CONTROLLER----");
		String cookie_user = null;
		Cookie[] cookies= req.getCookies();
		if(cookies != null) {	
			for(Cookie cookie : cookies){
		
			if(cookie.getName().equals("user")) {
			cookie_user = cookie.getValue();
			System.out.println(cookie_user);
			System.out.println(cookie.getName().equals("user")); //boolean validates function
			if(cookie_user !=null) {
		return "resources/html/emp_form.html";
		}
	} 
	 
}			

		}return "resources/html/emp_login.html";
}
}