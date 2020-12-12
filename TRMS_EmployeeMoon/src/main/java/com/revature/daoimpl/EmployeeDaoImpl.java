package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	public List<Employee> getEmpUserPass(){ 
		Connection conn = cf.getConnection();
		List<Employee> empUserList = new ArrayList<Employee>();
		
		try {
			String sql = "select * from employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				empUserList.add(new Employee(rs.getString(2),rs.getString(3)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empUserList;
	}
	

	public void insertEmployee(Employee ePerson) {
		Connection conn = cf.getConnection();
		try {
			String sql = "insert into employees values(DEFAULT,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ePerson.getUsername());
			ps.setString(2, ePerson.getPassword());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee getEmployeeByName(String username) { // getEmployee()
		Connection conn = cf.getConnection();
		Employee ePerson = null;
		try {
			String sql = "select * from employees where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ePerson = new Employee(rs.getInt(1), username, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return ePerson;
	
	}
	
	public List<Employee> getAllEmployees(){ // getAllEmployees()
		Connection conn = cf.getConnection();
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			String sql = "select * from employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				empList.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	}

	
}