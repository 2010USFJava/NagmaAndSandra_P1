package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeFormDao;
import com.revature.model.EmployeeForm;
import com.revature.util.ConnFactory;

public class EmployeeFormDaoImpl implements EmployeeFormDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public List<EmployeeForm> getAllEmployeesForm(){ // getAllEmployees()
		Connection conn = cf.getConnection();
		List<EmployeeForm> empFormList = new ArrayList<EmployeeForm>();
		
		try {
			String sql = "select * from event_form";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				empFormList.add(new EmployeeForm(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getDate(5),rs.getDate(6),rs.getTime(7),rs.getString(8),
						rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getDouble(16)));
			
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empFormList;
	}
	
	
	
	

}
