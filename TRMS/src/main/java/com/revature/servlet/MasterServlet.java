package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			System.out.println("in doGet");
			req.getRequestDispatcher(RequestHelper.process(req)).forward(req, res);
		}

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

			System.out.println("in doPost");
			req.getRequestDispatcher(RequestHelper.process(req)).forward(req, res);

		}
		
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			System.out.println("[Home]: Inside doPost");
//			doGet(request, response);
//		}
}
