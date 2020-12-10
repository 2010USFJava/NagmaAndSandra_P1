package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController {
	public static String logout(HttpServletRequest req, HttpServletResponse res) {
		return "resources/html/logout.html";

}
}
