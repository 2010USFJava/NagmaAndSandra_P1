package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("MasterServlet.java : in doGet");
		req.getRequestDispatcher(RequestHelper.process(req, res)).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("MasterServlet.java : in doPost");
		req.getRequestDispatcher(RequestHelper.process(req, res)).forward(req, res);
	
	}
	

}
