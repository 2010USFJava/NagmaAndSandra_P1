package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;

public class EmployeeController {
	public static String employee(HttpServletRequest req) {
		return "resources/html/Employee.html";
	}
	

}
