package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ApprovalDao;
import com.revature.model.Approval;
import com.revature.util.ConnFactory;

public class ApprovalDaoImpl implements ApprovalDao{

	public static ConnFactory cf = ConnFactory.getInstance();
	
//	String username = "root";
//	String password = "password";
//	String url = "jdbc:postgresql://sandradb.cbgpsxwsco96.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=trms";
	
	public List<Approval> getAllApprovers(){ // getAllApprovers()
		Connection conn = cf.getConnection();
		List<Approval> approvalList = new ArrayList<Approval>();
		
		try {
			//Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
			String sql = "select * from approvers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				approvalList.add(new Approval(rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return approvalList;
	}
	
	public List<Approval> getAllApproversInfo(){ // getAllApprovers()
		Connection conn = cf.getConnection();
		List<Approval> approvalList = new ArrayList<Approval>();
		
		try {
			//Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
			String sql = "select * from approvers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				approvalList.add(new Approval(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return approvalList;
	}
	

	public void insertApprover(Approval aPerson) {
		Connection conn = cf.getConnection();
		try {
			//Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
			String sql = "insert into approvers values(DEFAULT,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aPerson.getAid());
			ps.setInt(2, aPerson.getRole());
			ps.setString(3, aPerson.getUsername());
			ps.setString(4, aPerson.getPassword());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Approval getApproverByName(String username) { // getAllApprovers()
		Connection conn = cf.getConnection();
		Approval aPerson = new Approval();
		
		try {
			//Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
			String sql = "select * from approvers where a_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				aPerson.setAid(rs.getInt(1));
				aPerson.setRole(rs.getInt(2));
				aPerson.setUsername(rs.getString(3)); // Database positions
				aPerson.setPassword(rs.getString(4));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return aPerson;
	
	}

}