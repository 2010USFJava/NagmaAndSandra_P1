package com.revature.controller;

import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoimpl.EmployeeFormDaoImpl;
import com.revature.model.EmployeeForm;

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

		}
		return "resources/html/emp_login.html";
}
	
	public static String formData(HttpServletRequest req, HttpServletResponse res) 
	{
		if(!req.getMethod().equals("POST")) 
		{
			return "resources/html/emp_form.html";
		}
		
		String v = req.getParameter("n_eventType");	
		String eventType = null;
		
		switch(v) 
		{
		case "200":
	       eventType = "University Course";
	         break;
	    case "201":
	    	eventType = "Seminar";          
	        break;
	    case "202":
	    	eventType = "Certification Preparation Class";
	        break;
	    case "203":
	    	eventType = "Certification";
	        break;
	    case "204":
	    	eventType = "Techical Training";
	        break;
	    case "205":
	    	eventType = "Other";
	        break;
		}
		
		EmployeeForm ef = new EmployeeForm(0, req.getParameter("n_firstName"), req.getParameter("n_lastName"),
				Integer.parseInt(req.getParameter("n_employeeId")), Date.valueOf(LocalDate.now()), 
				Date.valueOf(req.getParameter("n_eventDate")), req.getParameter("n_eventTime"),
				req.getParameter("n_eventLocation"), Double.parseDouble(req.getParameter("n_eventCost")), 
				eventType, req.getParameter("n_description"), req.getParameter("n_gradingFormat"),
				req.getParameter("n_workRelJust"), req.getParameter("n_eventAttachment"), req.getParameter("n_workTimeMissed"),
				Double.parseDouble(req.getParameter("n_estimatedReimbursement")));
		
		EmployeeFormDaoImpl edi = new EmployeeFormDaoImpl();
		edi.saveEmployeeForm(ef);

		
//		return 
		
		return EmployeeController.employee(req, res);	
	}
}