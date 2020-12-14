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
}
