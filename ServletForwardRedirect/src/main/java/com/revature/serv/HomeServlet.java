package com.revature.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[Home]: Inside doGet");
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		request.getRequestDispatcher("resources/html/home.html").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[Home]: Inside doPost");
		doGet(request, response);
	}

}
