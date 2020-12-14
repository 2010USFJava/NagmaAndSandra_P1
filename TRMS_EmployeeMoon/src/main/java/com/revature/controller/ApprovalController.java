package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ApprovalDao;
import com.revature.dao.BalanceInfoDao;
import com.revature.dao.CommunicationTableDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeFormDao;
import com.revature.daoimpl.ApprovalDaoImpl;
import com.revature.daoimpl.BalanceInfoDaoImpl;
import com.revature.daoimpl.CommunicationTableDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.EmployeeFormDaoImpl;
import com.revature.model.Approval;
import com.revature.model.BalanceInfo;
import com.revature.model.CommunicationTable;
import com.revature.model.Employee;
import com.revature.model.EmployeeForm;

public class ApprovalController {
	public static ApprovalDao appdao = new ApprovalDaoImpl(); //Database Code
	public static EmployeeDao empdao = new EmployeeDaoImpl(); //Database Code
	public static EmployeeFormDao empformdao = new EmployeeFormDaoImpl(); //Database Code
	public static CommunicationTableDao commtabledao= new CommunicationTableDaoImpl(); //Database Code
	public static BalanceInfoDao baldao =  new BalanceInfoDaoImpl();
	public static List<Approval> appList;
	public static List<Employee> empList;	
	public static List<EmployeeForm> empFormList;
	public static List<CommunicationTable> commTableList;
	public static List<BalanceInfo> balanceInfoList;
	
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
	
	public static void getApproverSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("ApprovalController, getSessionApprover.java"); //debug code
		
		/* Call Employee DAO here to get there information*/
		//Approval aPerson = new Approval(1,2,"benco", "password");
		
		try {
			appList = appdao.getAllApproversInfo();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} // Database info 
		
		System.out.println("ApprovalController, getSessionApprover.java: aperson = " + appList ); //debug code
		
		/* Sending Employee info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Employee info to JsonRequestHelper which will convert to json data...\n");
		res.getWriter().write(new ObjectMapper().writeValueAsString(appList));
		
	}
	
	
	public static void getEmployeesSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("ApprovalController, getSessionEmployee.java"); //debug code
	
				empList = empdao.getAllEmployees();
				System.out.println("ApprovalController, getEmployeesSession: eperson = " + empList);
				res.getWriter().write(new ObjectMapper().writeValueAsString(empList));
		
		/* Sending Employee info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Employee info to JsonRequestHelper which will convert to json data...\n");
	}
	
	//Table 2
	public static void getEmployeesFormSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("ApprovalController, getEmployeesFormSession: "); //debug code
	
				try {
					empFormList = empformdao.getAllEmployeesForm();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				} 
				// Database info 
				System.out.println("ApprovalController, getEmployeesFormSession: eperson = " + empFormList);
				res.getWriter().write(new ObjectMapper().writeValueAsString(empFormList));
		
		/* Sending Employee Form info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Employee Form info to JsonRequestHelper which will convert to json data...\n");
	}
	//Table 3
	@JsonIgnore
	public static void getCommuncationTableSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("ApprovalController, getComsmuncationTableSession: "); //debug code
	
				try {
					commTableList = commtabledao.getAllCommunicationTable();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				} 
				// Database info 
				System.out.println("ApprovalController, getCommuncationTableSession: communication-table = " + commTableList);
				res.getWriter().write(new ObjectMapper().writeValueAsString(commTableList));
		
		/* Sending Employee Form info to JsonRequestHelper which will convert to json data */
		System.out.println("\nSending Communcation Table info to JsonRequestHelper which will convert to json data...\n");
	}
	
	
	public static String formData(HttpServletRequest req) {
		
		if(!req.getMethod().equals("POST")) {
		return "resources/html/app_response_form.html";
		}
		

		String formId = req.getParameter("n_formId"); // [1]
		String employeeId = req.getParameter("n_employeeId"); // [2]
		String estimReimbursement = req.getParameter("n_estimReimbursement"); // [3]
		String requestorNeedAdditionalInfoFrom = req.getParameter("n_requestorNeedAdditionalInfoFrom"); // [4]
		String requesteeResponse = req.getParameter("n_requesteeResponse"); // [5]
		String alteReimbursmentAmount = req.getParameter("n_alteReimbursmentAmount"); // [6]
		String reasonForLargerAmount = req.getParameter("n_reasonForLargerAmount"); // [7]
		String exceedingAvailableFunds = req.getParameter("n_exceedingAvailableFunds"); // [8]
		String pendingAmountVal= req.getParameter("n_pendingAmountVal"); // [9]
		String notifyEmployee = req.getParameter("n_notifyEmployee"); // [10]
		String employeeOptionToCancel = req.getParameter("n_employeeOptionToCancel"); // [11]
		String approvalStatus = req.getParameter("n_approvalStatus"); // [12]
		String eventGrade = req.getParameter("n_eventGrade"); // [13]
		String eventPresentation = req.getParameter("n_eventPresentation"); // [14]
		String mgmtViewPresent = req.getParameter("n_mgmtViewPresent"); // [15]
		String dirMgrApprPresent = req.getParameter("n_dirMgrApprPresent"); // [16]
		String gradeStatusDirectSup = req.getParameter("n_gradeStatusDirectSup"); // [17]
		String directSupAppr = req.getParameter("n_directSupAppr"); // [18]
		String deptHeadAppr = req.getParameter("n_deptHeadAppr"); // [19]
		String bencoFinalAppr = req.getParameter("n_bencoFinalAppr"); // [20]
		String finalReimburseValBenco = req.getParameter("n_finalReimburseValBenco"); //[21]
		String escalationEmailDirectSup = req.getParameter("n_escalationEmailDirectSup"); //[22]
		String automaticApprovDirectSup = req.getParameter("n_automaticApprovDirectSup"); //[23]
		String automaticApprovDeptHead = req.getParameter("n_automaticApprovDeptHead"); //[24]
		String markedUrgent = req.getParameter("n_markedUrgent"); //[25]

		// add benco info 
		
	
		CommunicationTable ePerson = new CommunicationTable(
				Integer.parseInt(req.getParameter("n_formId")), 
				Integer.parseInt(req.getParameter("n_employeeId")) , 
				Double.parseDouble(req.getParameter("n_estimReimbursement")) , 
				req.getParameter("n_requestorNeedAdditionalInfoFrom") , 
				req.getParameter("n_requesteeResponse") , 
				Double.parseDouble(req.getParameter("n_alteReimbursmentAmount")) ,
				req.getParameter("n_reasonForLargerAmount") , 
				req.getParameter("n_exceedingAvailableFunds") ,
				Double.parseDouble(req.getParameter("n_pendingAmountVal")), 
				req.getParameter("n_notifyEmployee"), 
				req.getParameter("n_employeeOptionToCancel") , 
				req.getParameter("n_approvalStatus"), 
				req.getParameter("n_eventGrade"), 
				req.getParameter("n_eventPresentation"),
				req.getParameter("n_mgmtViewPresent"),
				req.getParameter("n_dirMgrApprPresent"), 
				req.getParameter("n_gradeStatusDirectSup") , 
				req.getParameter("n_directSupAppr"), 
				req.getParameter("n_deptHeadAppr"), 
				req.getParameter("n_bencoFinalAppr") , 
				Double.parseDouble(req.getParameter("n_finalReimburseValBenco")), 
				req.getParameter("n_escalationEmailDirectup") ,
				req.getParameter("n_automaticApprovDirectSup") ,
				req.getParameter("n_automaticApprovDeptHead") ,
				req.getParameter("n_markedUrgent"));
		
	
			try {
				commtabledao.insertIntoCommunicationForm(ePerson);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
		System.out.println("[1] ApprovalController: formId : " + formId); //[1]
		System.out.println("[2] ApprovalController: employeeId : " + employeeId); //[2]
		System.out.println("[3] ApprovalController: estimReimbursement : " + estimReimbursement ); //[3]
		System.out.println("[4] ApprovalController: requestorNeedAdditionalInfoFrom : " + requestorNeedAdditionalInfoFrom); //[4]
		System.out.println("[5] ApprovalController: requesteeResponse " + requesteeResponse); //[5]
		System.out.println("[6] ApprovalController: alterReimbursmentAmount  :" + alteReimbursmentAmount); //  [6]
		System.out.println("[7] ApprovalController: reasonForLargerAmount  :" + reasonForLargerAmount); // [7]
		System.out.println("[8] ApprovalController: exceedingAvailableFunds :" + exceedingAvailableFunds); // [8]
		System.out.println("[9] ApprovalController: pendingAmountVal  :" + pendingAmountVal); // [9]
		System.out.println("[10] ApprovalController: notifyEmployee  :" + notifyEmployee); // [10]
		System.out.println("[11] ApprovalController: employeeOptionToCancel  :" + employeeOptionToCancel); // [11]
		System.out.println("[12] ApprovalController: approvalStatus : " + approvalStatus); // [12]
		System.out.println("[13] ApprovalController: eventGrade : " + eventGrade); // [13]
		System.out.println("[14] ApprovalController: eventPresentation : " + eventPresentation); // [14]
		System.out.println("[15] ApprovalController: mgmtViewPresent : " + mgmtViewPresent); // [15]
		System.out.println("[16] ApprovalController: dirMgrApprPresent : " + dirMgrApprPresent); // [16]
		System.out.println("[17] ApprovalController: gradeStatusDirectSup : " + gradeStatusDirectSup); // [17]
		System.out.println("[18] ApprovalController: directSupAppr : " + directSupAppr); // [18]
		System.out.println("[19] ApprovalController: deptHeadAppr : " + deptHeadAppr); // [19]
		System.out.println("[20] ApprovalController: bencoFinalAppr : " + bencoFinalAppr); // [20]
		System.out.println("[21] ApprovalController: finalReimburseValBenco : " + finalReimburseValBenco); // [21]
		System.out.println("[22] ApprovalController: escalationEmailDirectSup : " + escalationEmailDirectSup); // [22] 
		System.out.println("[23] ApprovalController: automaticApprovDirectSup : " + automaticApprovDirectSup); // [23]
		System.out.println("[24] ApprovalController: automaticApprovDeptHead : " + automaticApprovDeptHead); // [24]
		System.out.println("[25] ApprovalController: markedUrgent  : " + markedUrgent); // [25]

		return ApprovalController.approval(req);
		
	}
	
public static String formMgmt(HttpServletRequest req) {
		
		if(!req.getMethod().equals("POST")) {
		return "resources/html/app_response_form.html";
		}
		String formId = req.getParameter("n_formId"); // [1]
		String mgmtViewPresent = req.getParameter("n_mgmtViewPresent"); // [15]
		
		CommunicationTable ePerson = new CommunicationTable(
				Integer.parseInt(req.getParameter("n_formId")), 
				req.getParameter("n_mgmtViewPresent"));
	
			try {
				commtabledao.updateMgmtInfo(ePerson);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		System.out.println("[1] ApprovalController: formId : " + formId); //[1]
		System.out.println("[15] ApprovalController: mgmtViewPresent : " + mgmtViewPresent); // [15]

		return ApprovalController.approval(req);	
	}


		public static String dirMgmt(HttpServletRequest req) {
			
			if(!req.getMethod().equals("POST")) {
				return "resources/html/app_response_form.html";
				}
				String formId = req.getParameter("n_formId"); // [1]
				String dirMgrApprPresent = req.getParameter("n_dirMgrApprPresent"); // [15]
				
				CommunicationTable ePerson = new CommunicationTable();
				
				ePerson.setFormId(Integer.parseInt(req.getParameter("n_formId")));
				ePerson.setDirMgrApprPresent(dirMgrApprPresent);
						
			
					try {
						commtabledao.updateDirMgrInfo(ePerson);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				System.out.println("[1] ApprovalController: formId : " + formId); //[1]
				System.out.println("[15] ApprovalController: dirMgrApprPresent : " + dirMgrApprPresent); // [15]

				return ApprovalController.approval(req);

		
		}
		public static String dirSup(HttpServletRequest req) {
			
			if(!req.getMethod().equals("POST")) {
				return "resources/html/app_response_form.html";
				}
				String formId = req.getParameter("n_formId"); // [1]
				String requestorNeedAdditionalInfoFrom = req.getParameter("n_requestorNeedAdditionalInfoFrom"); //[4]
				String notifyEmployee = req.getParameter("n_notifyEmployee"); // [10]
				String gradeStatusDirectSup = req.getParameter("n_gradeStatusDirectSup"); // [17]
				String markedUrgent = req.getParameter("n_markedUrgent"); //[25]
				String escalationEmailDirectSup = req.getParameter("n_escalationEmailDirectSup"); //[22]
				String automaticApprovDirectSup = req.getParameter("n_automaticApprovDirectSup"); //[23]
				String directSupAppr = req.getParameter("n_directSupAppr"); // [18]
				
				
				CommunicationTable ePerson = new CommunicationTable();
				
				ePerson.setFormId(Integer.parseInt(req.getParameter("n_formId")));
				ePerson.setRequestorNeedAdditionalInfoFrom(requestorNeedAdditionalInfoFrom);
				ePerson.setNotifyEmployee(notifyEmployee);
				ePerson.setGradeStatusDirectSup(gradeStatusDirectSup);
				ePerson.setMarkedUrgent(markedUrgent);
				ePerson.setEscalationEmailDirectSup(escalationEmailDirectSup);
				ePerson.setAutomaticApprovDirectSup(automaticApprovDirectSup);
				ePerson.setDirectSupAppr(directSupAppr);
			
					try {
						commtabledao.updateDirSupInfo(ePerson);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("[1] ApprovalController: formId : " + formId); //[1]
					System.out.println("[4] ApprovalController: requestorNeedAdditionalInfoFrom : " + requestorNeedAdditionalInfoFrom); //[4]
					System.out.println("[10] ApprovalController: notifyEmployee  :" + notifyEmployee); // [10]
					System.out.println("[17] ApprovalController: gradeStatusDirectSup : " + gradeStatusDirectSup); // [17]
					System.out.println("[18] ApprovalController: directSupAppr : " + directSupAppr); // [18]
					System.out.println("[22] ApprovalController: escalationEmailDirectSup : " + escalationEmailDirectSup); // [22] 
					System.out.println("[23] ApprovalController: automaticApprovDirectSup : " + automaticApprovDirectSup); // [23]
					System.out.println("[25] ApprovalController: markedUrgent  : " + markedUrgent); // [25]
					
				return ApprovalController.approval(req);
				
		}

		
		public static String deptHead(HttpServletRequest req) {
			
			if(!req.getMethod().equals("POST")) {
				return "resources/html/app_response_form.html";
				}
				String formId = req.getParameter("n_formId"); // [1]

				CommunicationTable ePerson = new CommunicationTable();
				
				ePerson.setFormId(Integer.parseInt(req.getParameter("n_formId")));

					try {
						commtabledao.updateDirSupInfo(ePerson);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("[1] ApprovalController: formId : " + formId); //[1]
	
				return ApprovalController.approval(req);
			
			
		}
		public static String benco(HttpServletRequest req) {
			
			if(!req.getMethod().equals("POST")) {
				return "resources/html/app_response_form.html";
				}
				String formId = req.getParameter("n_formId"); // [1]
				String employeeId = req.getParameter("n_employeeId"); // [2]
				String alteReimbursmentAmount = req.getParameter("n_alteReimbursmentAmount"); // [6]
				String approvalStatus = req.getParameter("n_approvalStatus"); // [12]
				String bencoFinalAppr = req.getParameter("n_bencoFinalAppr"); // [20]
				String finalReimburseValBenco = req.getParameter("n_finalReimburseValBenco"); //[21]
				
				CommunicationTable ePerson = new CommunicationTable();
				
				ePerson.setFormId(Integer.parseInt(req.getParameter("n_formId")));
				ePerson.setEmployeeId(Integer.parseInt(req.getParameter("n_employeeId"))); // [2]
				ePerson.setAlterReimbursmentAmount(Double.parseDouble(req.getParameter("n_alteReimbursmentAmount")));
				ePerson.setApprovalStatus(req.getParameter("n_approvalStatus"));
				ePerson.setBencoFinalAppr(req.getParameter("n_bencoFinalAppr"));
				ePerson.setFinalReimburseValBenco(Double.parseDouble(req.getParameter("n_finalReimburseValBenco")));
				
				
				// Calculate final balance
				
				//double cost = Double.parseDouble(req.getParameter("n_finalReimburseValBenco"));
				//System.out.println("[21] ApprovalController: cost : " + cost); // [21]
				
			
					try {
						commtabledao.updateBencoInfo(ePerson); //works
						//baldao.updateAvailableBalance(aPerson); // work
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("[1] ApprovalController: formId : " + formId); //[1]
					System.out.println("[2] ApprovalController: employeeId : " + employeeId); //[2]
					System.out.println("[6] ApprovalController: alterReimbursmentAmount  :" + alteReimbursmentAmount); //  [6]
					System.out.println("[12] ApprovalController: approvalStatus : " + approvalStatus); // [12]
					System.out.println("[20] ApprovalController: bencoFinalAppr : " + bencoFinalAppr); // [20]
					System.out.println("[21] ApprovalController: finalReimburseValBenco : " + finalReimburseValBenco); // [21]
	
				return ApprovalController.approval(req);
			
		}
		
		


	
	
	
}
