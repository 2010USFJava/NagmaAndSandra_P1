package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeFormDao;
import com.revature.model.EmployeeForm;
import com.revature.util.ConnFactory;

public class EmployeeFormDaoImpl implements EmployeeFormDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public List<EmployeeForm> getAllEmployeesForm(){ // getAllEmployees()
		Connection conn = cf.getConnection();
		List<EmployeeForm> empFormList = new ArrayList<EmployeeForm>();
		
		try 
		{
			String sql = "select * from event_form";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				empFormList.add(new EmployeeForm(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8),
						rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getDouble(16)));
			}
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return empFormList;
	}
	
	
	public void saveEmployeeForm(EmployeeForm ef) 
	{
		Connection conn = cf.getConnection();
		
		try 
		{
			String sql = "insert into event_form values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ef.getFirstName());
			ps.setString(2, ef.getLastName());
			ps.setInt(3,ef.getEmployeeId());
			ps.setDate(4, Date.valueOf(LocalDate.now()));
			ps.setDate(5, Date.class.cast(ef.getEventDate()));
			ps.setString(6, ef.getEventTime());
			ps.setString(7, ef.getEventLocation());
			ps.setDouble(8, ef.getEventCost());
			ps.setString(9, ef.getEventType());
			ps.setString(10, ef.getDescription());
			ps.setString(11, ef.getGradingFormat());
			ps.setString(12, ef.getWorkRelJust());
			ps.setString(13, ef.getEventAttachment());
			ps.setString(14, ef.getWorkTimeMissed());
			ps.setDouble(15, ef.getEstimatedReimbursement());
			ps.executeUpdate();
	
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}			
	}
	public List<EmployeeForm> getAllFormsByEmp(int empId) {
		Connection conn = cf.getConnection();
		List<EmployeeForm> empFormByEmp = new ArrayList<EmployeeForm>();
		
		try 
		{
			String sql = "select * from event_form where empid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,empId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				empFormByEmp.add(new EmployeeForm(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8),
						rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getDouble(16)));
			}
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return empFormByEmp;
		
	}
	
}
