package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnFactory;
import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
		
	public static ConnFactory cf = ConnFactory.getInstance();

	
		public List<Employee> getAllEmployees(){ // getAllEmployees()
			Connection conn = cf.getConnection();
			List<Employee> empList = new ArrayList<Employee>();
			
			try {
				String sql = "select * from petra_employees";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					empList.add(new Employee(0, rs.getString(2),rs.getString(3), sql, sql, sql, 0, 0));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return empList;
		}
		

		public void insertEmployee(Employee ePerson) {
			Connection conn = cf.getConnection();
			try {
				String sql = "insert into petra_employees values(DEFAULT,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, ePerson.getId());
				ps.setString(2, ePerson.getUsername());
				ps.setString(3, ePerson.getPassword());
				/* Petra can you complete*/
				ps.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public Employee getEmployeeByName(String username) { // getEmployee()
			Connection conn = cf.getConnection();
			Employee ePerson = null;
//			try {
//				String sql = "select * from employees where username=?";
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setString(1, username);
//				ResultSet rs = ps.executeQuery();
//				while(rs.next()) {
//					ePerson = new Employee(rs.getInt(1), username, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9));
//					
//				}	
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}	
			return ePerson;
		
		}
}
