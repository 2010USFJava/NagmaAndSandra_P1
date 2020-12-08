package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Approvals;

public class ApprovalController {
	
	public static String approval(HttpServletRequest req) {
		//System.out.println("ApprovalController: role: " + req.getSession().getAttribute("currentrole"));
		
		Object role = req.getSession().getAttribute("currentrole");
		if(role.equals(1)) {
			System.out.println("ApprovalController: role: " + role);
			
			return "resources/html/approval_benco.html";
		}
		if(role.equals(2)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/approval_direct_superviser.html";
		}
		if(role.equals(3)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/approval_direct_head.html";
		}
		if(role.equals(4)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/approval_mgmt.html";
		}
		if(role.equals(5)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/approval_direct_mgmt.html";
		}
		else {
			System.out.println("ApprovalController: role: " + req.getSession().getAttribute("currentrole"));
			return "resources/html/approval.html";
		}
		
	}
	
	public static void getSessionApprover(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		System.out.println("ApprovalController, getSessionApprover.java");
		//Object aPerson =  req.getSession().getAttribute("currentApprover");
		Approvals aPerson = new Approvals(1,2,"benco", "password");
		
		// here is where i will grab the employee data and parse it
		System.out.println("ApprovalController, getSessionApprover.java: aperson = " + aPerson );
		res.getWriter().write(new ObjectMapper().writeValueAsString(aPerson));
		//System.out.println("ApprovalController.java: " + "getSessionApprover : " + aPerson);
	}
	
//	public static void getSessionApproverRole(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
//		Approvals aPersonRole = (Approvals) req.getSession().getAttribute("currentrole");
//		res.getWriter().write(new ObjectMapper().writeValueAsString(aPersonRole)); //response
//		
//	}

}
