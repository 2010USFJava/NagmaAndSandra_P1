package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Approval;

public class ApprovalController {
	
	public static String approval(HttpServletRequest req) {
		//System.out.println("ApprovalController: role: " + req.getSession().getAttribute("currentrole"));
		
		Object role = req.getSession().getAttribute("currentrole");
		if(role.equals(1)) {
			System.out.println("ApprovalController: role: " + role);
			
			return "resources/html/app_benco.html";
		}
		if(role.equals(2)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/app_direct_superviser.html";
		}
		if(role.equals(3)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/app_direct_head.html";
		}
		if(role.equals(4)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/app_mgmt.html";
		}
		if(role.equals(5)) {
			System.out.println("ApprovalController: role: " + role);
			return "resources/html/app_direct_mgmt.html";
		}
		else {
			System.out.println("ApprovalController: role: " + req.getSession().getAttribute("currentrole"));
			return "resources/html/app_benco.html";
		}
		
	}
	
	public static void getSessionApprover(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("ApprovalController, getSessionApprover.java"); //debug code
		
		/* Call Employee DAO here to get there information*/
		Approval aPerson = new Approval(1,2,"benco", "password");
		
		
		System.out.println("ApprovalController, getSessionApprover.java: aperson = " + aPerson ); //debug code
		
		/* Sending Employee info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Employee info to JsonRequestHelper which will convert to json data...\n");
		res.getWriter().write(new ObjectMapper().writeValueAsString(aPerson));
		
	}
	
//	public static void getSessionApproverRole(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
//		Approvals aPersonRole = (Approvals) req.getSession().getAttribute("currentrole");
//		res.getWriter().write(new ObjectMapper().writeValueAsString(aPersonRole)); //response
//		
//	}

}
