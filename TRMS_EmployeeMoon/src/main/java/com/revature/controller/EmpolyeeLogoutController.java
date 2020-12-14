package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmpolyeeLogoutController {
	public static String logout(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("-----LOGOUT CONTROLLER----");
		HttpSession session = req.getSession();
		session.setAttribute("currentuser", "");
		System.out.println(session.getAttribute("currentuser"));
		session.setAttribute("JSESSIONID", "");
		
		Cookie logoutCookie = null;
		logoutCookie = new Cookie("user", "");
		logoutCookie.setMaxAge(0);
		res.addCookie(logoutCookie);
		Cookie logoutSession = null;
		logoutSession = new Cookie("JSESSIONID", "");
		logoutSession.setMaxAge(0);
		res.addCookie(logoutSession);
		return LogoutController.logout(req, res);
	}
}

