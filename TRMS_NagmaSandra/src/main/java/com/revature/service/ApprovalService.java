package com.revature.service;


import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ApprovalDao;
import com.revature.daoimpl.ApprovalDaoImpl;
import com.revature.model.Approvals;

public class ApprovalService {
	
	public static ApprovalDao apdao = new ApprovalDaoImpl();
	public List<Approvals> approvalList;
	
	public boolean loginVerify(String username, String password) {
		
		try {
			
			approvalList = apdao.getAllApprovers();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		boolean verify = false;
		for(Approvals aPerson: approvalList) {
			System.out.println("ApprovalService.java: javascript name: " + username + " " + password); //<-- debug notes  This is where the javascript is coming in
			System.out.println("ApprovalService.java: sql name: " + aPerson.getUsername() + " " + aPerson.getPassword()); //<-- debug notes  sql names
			if(aPerson.getUsername().equals(username)&& aPerson.getPassword().equals(password)) {
				verify = true;
			}
		}
		return verify;
	}
	
	public Approvals loginGetApproval(String username, String password) {
		
		if(loginVerify(username, password)) {
				System.out.println(" ApprovalService.java: login good :" + username);
				try {
					
					return apdao.getApproverByName(username); // <-- This is where the database if is pulled
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}
		return null;
	}
	
//	public void insertNewVillain(SuperVillain vill) {
//		svdao.insertVillain(vill);
//	}

//	public VillainService() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	


}
