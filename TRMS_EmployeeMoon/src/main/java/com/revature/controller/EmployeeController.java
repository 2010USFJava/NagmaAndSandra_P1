package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeController {
	
	public static EmployeeDao empdao = new EmployeeDaoImpl();
	public static Employee emp = new Employee();
	
	public static String employee(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("-----EMPLOYEE HOME CONTROLLER----");
		return "resources/html/employee.html";
		
	}
	
	public static void getOneEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException, SQLException{
		System.out.println("EmployeeController, getSessionEmployee.java"); //debug code
			
				String username = null;
				Cookie[] cookies= req.getCookies();
				if(cookies != null) {	
					for(Cookie cookie : cookies){
				
					if(cookie.getName().equals("user")) {
					username = cookie.getValue();
					System.out.println(username);
					System.out.println(cookie.getName().equals("user")); } }}
				emp = empdao.getEmployeeByName(username);
				System.out.println("EmployeeController, getOneEmployee: eperson = " + emp);
				res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
		
		/* Sending Employee info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Employee info to JsonRequestHelper which will convert to json data...\n");
	}

}

			


	
