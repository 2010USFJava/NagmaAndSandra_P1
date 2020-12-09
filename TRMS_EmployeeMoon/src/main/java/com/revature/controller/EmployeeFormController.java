package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class EmployeeFormController {
	public static String form(HttpServletRequest req) {
		return "resources/html/emp_form.html";
	}
}
