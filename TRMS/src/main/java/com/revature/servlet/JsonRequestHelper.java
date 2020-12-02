package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Employee;
import com.revature.controller.EmployeeController;


public class JsonRequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		switch(req.getRequestURI()) {
		
		case "/TRMS/getsession.json":
			EmployeeController.getSessionEmployee(req, res);
			break;
		
		default:
			Employee e1 = new Employee("?","?", "?","?");
			res.getWriter().write(new ObjectMapper().writeValueAsString(e1));
		}
		
	}

}
