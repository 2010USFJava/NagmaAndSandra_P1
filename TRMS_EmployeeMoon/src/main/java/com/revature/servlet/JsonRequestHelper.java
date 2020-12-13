package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.ApprovalController;
import com.revature.controller.EmployeeController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.EmployeeStatusController;
import com.revature.model.Approval;

/*
 * Parse Employee data from database and send to getsession.json link
 */

public class JsonRequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException, SQLException{
		
		System.out.println("JsonRequestHelper.java : ");
		
		switch(req.getRequestURI()) {	
			case "/TRMS_EmployeeMoon/getsession.json":
			System.out.println("JsonRequestHelper.java : " + "getsession.json");
			System.out.println("\nConvert to json data...\n");
			ApprovalController.getSessionApprover(req, res);
			break;
			
		case "/TRMS_EmployeeMoon/getOneEmployee.json":  //One Employee INFO json info
			System.out.println("JsonRequestHelper.java : " + "getOneEmployee.json");
			System.out.println("\nConvert to json data...\n");
			EmployeeController.getOneEmployee(req, res);
				break;
		
		case "/TRMS_EmployeeMoon/getBalById.json":  //One Employee INFO json info
			System.out.println("JsonRequestHelper.java : " + "getOneEmployee.json");
			System.out.println("\nConvert to json data...\n");
			EmployeeController.getBalById(req, res);
				break;
				
		case "/TRMS_EmployeeMoon/getAllFormsByEmp.json":  //One Employee INFO json info
			System.out.println("JsonRequestHelper.java : " + "getOneEmployee.json");
			System.out.println("\nConvert to json data...\n");
			EmployeeFormController.getEmployeeForm(req, res);
				break;
				
		case "/TRMS_EmployeeMoon/getCommuncationTableSession.json":  //Employee Form INFO json info
			System.out.println("JsonRequestHelper.java : " + "getCommuncationTableSession.json");
			System.out.println("\nConvert to json data...\n");
			EmployeeStatusController.getCommuncationTableSession(req, res);
			break; 
			
		default:
			Approval aPerson = new Approval(0,"?","?");
			res.getWriter().write(new ObjectMapper().writeValueAsString(aPerson));
			System.out.println("JsonRequestHelper.java : " + aPerson);
			}
	}

}
