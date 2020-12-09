package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class StatusController {
	public static String status(HttpServletRequest req) {
		return "resources/html/status.html";
	}
}
