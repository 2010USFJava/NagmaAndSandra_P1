package com.revature.controller;

import java.time.LocalDate;
import java.util.List;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.EmployeeFormDaoImpl;
import com.revature.model.Employee;
import com.revature.model.EmployeeForm;
import com.revature.util.LogThis;

public class EmployeeFormController {
	
	public static EmployeeDao empdao = new EmployeeDaoImpl();
	public static Employee emp = new Employee();
	public static EmployeeFormDaoImpl empformdao = new EmployeeFormDaoImpl();
	public static EmployeeForm empform = new EmployeeForm();
	public static List<EmployeeForm> empFormByEmp;
	
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
		System.out.println("-----FORM CONTROLLER/ FORM DATA METHOD----");
		if(!req.getMethod().equals("POST")) 
		{
			return "resources/html/emp_form.html";
		}
		
		String value = req.getParameter("n_eventType");	
		String eventType = null;
		
		switch(value) 
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
		
		empformdao.saveEmployeeForm(ef);
		LogThis.LogIt("info", "New Form '" + ef.getId() + "' submmited by employee, " + ef.getFirstName() + ", employee id = " + ef.getEmployeeId());
		
		return EmployeeController.employee(req, res);	
	}
	
	public static void getEmployeeForm(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException, SQLException{
		System.out.println("EmployeeFormController, getEmployeeForm.java"); //debug code
			
				String username = null;
				Cookie[] cookies= req.getCookies();
				if(cookies != null) {	
					for(Cookie cookie : cookies){
				
					if(cookie.getName().equals("user")) {
					username = cookie.getValue();
					System.out.println(username);
					System.out.println(cookie.getName().equals("user")); } }} //boolean to confirm cookie exists
				
				emp = empdao.getEmployeeByName(username);
				int empId = emp.getEmpId();
				System.out.println(empId);
				empFormByEmp = empformdao.getAllFormsByEmp(empId);
				System.out.println("EmployeeFormController, getEmployeeForm: epersonForms = " + empFormByEmp);
				res.getWriter().write(new ObjectMapper().writeValueAsString(empFormByEmp));
		
		/* Sending Employee info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Employee info to JsonRequestHelper which will convert to json data...\n");
	}
	
}