package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.controller.EmployeeController;
import com.revature.dao.CommunicationTableDao;
import com.revature.model.CommunicationTable;
import com.revature.util.ConnFactory;

public class CommunicationTableDaoImpl implements CommunicationTableDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	public List<CommunicationTable> getAllCommunicationTable(){ // getAllEmployees()
		Connection conn = cf.getConnection();
		List<CommunicationTable> commTableList = new ArrayList<CommunicationTable>();
		
		try {
			String sql = "select * from communication_table";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				commTableList.add(new CommunicationTable(
				rs.getInt(1), rs.getInt(2), rs.getDouble(3), 
				
				rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8),
				rs.getDouble(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
				
				rs.getString(15),rs.getString(16),
				
				rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getDouble(21),
				rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25)));
				
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return commTableList;
	}
	
	public CommunicationTable updateCommTable(CommunicationTable commTable) {
		Connection conn = cf.getConnection();
		
		try {
			String sql = "update communication_table set requestee_response=?, employee_option_to_cancel=?, event_grade=?, event_presentation=? where form_id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, commTable.getRequesteeResponse());
			ps.setString(2, commTable.getEmployeeOptionToCancel());
			ps.setString(3, commTable.getEventGrade());
			ps.setString(4, commTable.getEventPresentation());
			ps.setInt(5, commTable.getFormId());
			ps.execute();
			
			}
			catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return commTable;
		
	}
	public void insertIntoCommunicationForm(CommunicationTable ePerson) throws SQLException{
		Connection conn = cf.getConnection();
		
			String sql = "insert into communication_table values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
	         	ps.setInt(1, ePerson.getFormId());
				ps.setInt(2, ePerson.getEmployeeId());
				ps.setDouble(3, ePerson.getEstimReimbursement());
				ps.setString(4, ePerson.getRequestorNeedAdditionalInfoFrom()); //4
				ps.setString(5, ePerson.getRequesteeResponse()); //5
				ps.setDouble(6, ePerson.getAlterReimbursmentAmount()); //6
				ps.setString(7, ePerson.getReasonForLargerAmount()); //7
				ps.setString(8, ePerson.getExceedingAvailableFunds()); //8
				ps.setDouble(9, ePerson.getPendingAmountVal()); //9
				ps.setString(10, ePerson.getNotifyEmployee()); //10
				ps.setString(11, ePerson.getEmployeeOptionToCancel()); //11
				ps.setString(12, ePerson.getApprovalStatus()); //12
				ps.setString(13, ePerson.getEventGrade()); //13
				ps.setString(14, ePerson.getEventPresentation()); //14
				ps.setString(15, ePerson.getMgmtViewPresent()); //15
				ps.setString(16, ePerson.getDirMgrApprPresent()); //16
				ps.setString(17, ePerson.getGradeStatusDirectSup()); //17
				ps.setString(18, ePerson.getDirectSupAppr()); //18
				ps.setString(19, ePerson.getDeptHeadAppr()); //19
				ps.setString(20, ePerson.getBencoFinalAppr()); //20
				ps.setDouble(21, ePerson.getFinalReimburseValBenco()); //21
				ps.setString(22, ePerson.getEscalationEmailDirectSup()); //22
				ps.setString(23, ePerson.getAutomaticApprovDirectSup()); //23
				ps.setString(24, ePerson.getAutomaticApprovDeptHead()); //24
				//ps.setString(25, ePerson.getMarkedUrgent()); //25
				ps.executeUpdate();
			
	}
	
	
	public void updateMgmtInfo(CommunicationTable ePerson) throws SQLException{
		Connection conn = cf.getConnection();
		
		String sql = "update communication_table set mgmt_view_present=? where form_id=?;";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ePerson.getMgmtViewPresent());
		ps.setInt(2, ePerson.getFormId()); 
		
		ps.executeUpdate();
	}
	
	
	public void updateDirMgrInfo(CommunicationTable ePerson) throws SQLException{
		Connection conn = cf.getConnection();
		
		String sql = "update communication_table set dir_mgr_appr_present=? where form_id=?;";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ePerson.getDirMgrApprPresent());
		ps.setInt(2, ePerson.getFormId()); 
		
		ps.executeUpdate();
	}
	
	public void updateDirSupInfo(CommunicationTable ePerson) throws SQLException{
			Connection conn = cf.getConnection();
			
			String sql = "update communication_table set requestor_need_additional_info_from=?, notify_employee=?, grade_status_direct_sup=?, direct_sup_appr=?, escalation_email_direct_sup=?, automatic_approv_direct_sup=?, marked_urgent=?  where form_id=?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ePerson.getRequestorNeedAdditionalInfoFrom());
			ps.setString(2, ePerson.getNotifyEmployee());
			ps.setString(3, ePerson.getGradeStatusDirectSup());
			ps.setString(4, ePerson.getDirectSupAppr());
			ps.setString(5, ePerson.getEscalationEmailDirectSup());
			ps.setString(6, ePerson.getAutomaticApprovDirectSup());
			ps.setString(7, ePerson.getMarkedUrgent());
			ps.setInt(8, ePerson.getFormId()); 
			
			ps.executeUpdate();
		}
		
		public void updateDeptHeadInfo(CommunicationTable ePerson) throws SQLException{}
		
		public void updateBencoInfo(CommunicationTable ePerson) throws SQLException{
			
				Connection conn = cf.getConnection();
			
			String sql = "update communication_table set alter_reimbursment_amount=?, approval_status=?, benco_final_appr=?, final_reimburse_val_benco =? where form_id=?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, ePerson.getAlterReimbursmentAmount());
			ps.setString(2, ePerson.getApprovalStatus()); //12
			ps.setString(3, ePerson.getBencoFinalAppr());
			ps.setDouble(4, ePerson.getFinalReimburseValBenco());
			ps.setInt(5, ePerson.getFormId()); 
			
			ps.executeUpdate();
			
		}
		
	
	
}
