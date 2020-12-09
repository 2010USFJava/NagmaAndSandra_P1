package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class EmployeeHistoryController {
	public static String history(HttpServletRequest req) {
		return "resources/html/emp_history.html";
	}
}
