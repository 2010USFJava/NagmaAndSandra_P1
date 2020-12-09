package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class EmployeeStatusController {
	public static String status(HttpServletRequest req) {
		return "resources/html/emp_status.html";
	}
}
