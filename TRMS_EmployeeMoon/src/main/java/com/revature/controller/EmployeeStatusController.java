package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.CommunicationTableDao;
import com.revature.daoimpl.CommunicationTableDaoImpl;
import com.revature.model.CommunicationTable;
import com.revature.util.LogThis;

public class EmployeeStatusController {
	
	public static CommunicationTableDaoImpl commtableimpl = new CommunicationTableDaoImpl(); //Database Code
	public static List<CommunicationTable> commTableList;
	
	public static String status(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("-----STATUS CONTROLLER----");
		String cookie_user = null;
		Cookie[] cookies = req.getCookies();
		
		if(cookies !=null){
			for(int i=0;i<cookies.length;i++){ 
			if(cookies[i].getName().equals("user")) {cookie_user = cookies[i].getValue();
			System.out.println(cookies[i].getName().equals("user")); //boolean validates function
			System.out.println("EmpLoginController:" + cookie_user);
			}}}
			if(cookie_user !=null) {
//				Cookie logoutCookie = null;
//				logoutCookie = new Cookie("user", "");
//				logoutCookie.setMaxAge(0);
//				res.addCookie(logoutCookie);
		
		return "resources/html/emp_status.html";
		}
			
			return EmployeeLoginController.login(req, res);
}
	
	public static void getCommuncationTableSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("EmployeeStatusController, getCommuncationTableSession: "); //debug code
	
				commTableList = commtableimpl.getAllCommunicationTable(); 
				// Database info 
				System.out.println("StatusController, getCommuncationTableSession: communication-table = " + commTableList);
				res.getWriter().write(new ObjectMapper().writeValueAsString(commTableList));
		
		/* Sending Employee Form info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Communcation Table info to JsonRequestHelper which will convert to json data...\n");
	}
	
	public static String statusResponse(HttpServletRequest req, HttpServletResponse res) {
		
		if(!req.getMethod().equals("POST")) {
		return "resources/html/employeestatus.html";
		}
		

		int formId = Integer.parseInt(req.getParameter("n_form_id")); // [1]
		String addInfo = req.getParameter("n_addInfo"); // [5]
		String appOrCancel = req.getParameter("n_approve"); // [11]
		String eventGrade = req.getParameter("n_grade"); // [13]
		String eventPresentation = req.getParameter("n_file"); // [14]

		CommunicationTable commTable = new CommunicationTable(addInfo, appOrCancel, eventGrade, eventPresentation, formId);
		
		LogThis.LogIt("info", "Form '" + commTable.getFormId() + "' updated with response.");
		
		commtableimpl.updateCommTable(commTable);
		
		return EmployeeController.employee(req, res);
		
	}
}
