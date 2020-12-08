package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.ApprovalController;
import com.revature.model.Approval;

/*
 * Parse Employee data from database and send to getsession.json link
 */

public class JsonRequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		System.out.println("JsonRequestHelper.java : ");
		switch(req.getRequestURI()) {	
			case "/TRMS_NagmaSandra/getsession.json":
			System.out.println("JsonRequestHelper.java : " + "getsession.json");
			System.out.println("\nConvert to json data...\n");
			ApprovalController.getSessionApprover(req, res);
			
			break;
			
			default:
				Approval aPerson = new Approval(0,"?","?");
				res.getWriter().write(new ObjectMapper().writeValueAsString(aPerson));
				System.out.println("JsonRequestHelper.java : " + aPerson);
			}
	}

}
