package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.bean.Employee;

public class EmployeeController {
	
	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		
		Employee e1 = (Employee) req.getSession().getAttribute("currentuser");
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(e1));
	}
	

}
