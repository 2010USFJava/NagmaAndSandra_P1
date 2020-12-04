package com.revature.service;


import java.util.List;

import com.revature.dao.ApprovalDao;
import com.revature.model.Approvals;

public class ApprovalService {
	
	ApprovalDao apdao = new ApprovalDao();
	
	
	public boolean loginVerify(String username, String password) {
		
		List<Approvals> approvalList =  apdao.getAllApprovers(); // DAO --> getAllApprovers()
		
		//Approvals aPerson= new Approvals("admin","admin");

		boolean verify = false;
		for(Approvals aPerson: approvalList) {
			System.out.println(username + " " + password);
			
			if(aPerson.getUsername().equals(username)&& aPerson.getPassword().equals(password)) {
				verify = true;
			}
		}
		return verify;
	
		
	}
	
	public Approvals loginGetApproval(String username, String password) {
		
		//Approvals aPerson= new Approvals("admin","admin");
		
		if(loginVerify(username, password)) {
				System.out.println("login good :" + username);
				return apdao.getApproverByName(username); //DAO --> getApproverByName()
				//return aPerson;
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
