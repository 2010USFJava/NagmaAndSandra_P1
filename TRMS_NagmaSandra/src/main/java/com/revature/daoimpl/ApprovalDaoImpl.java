package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ApprovalDao;
import com.revature.model.Approvals;
import com.revature.util.ConnFactory;

public class ApprovalDaoImpl implements ApprovalDao{

	public static ConnFactory cf = ConnFactory.getInstance();
	String username = "root";
	String password = "password";
	String url = "jdbc:postgresql://sandradb.cbgpsxwsco96.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=trms";
	
	public List<Approvals> getAllApprovers(){ // getAllApprovers()
		//Connection conn = cf.getConnection();
		List<Approvals> approvalList = new ArrayList<Approvals>();
		
		try {
			Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
			String sql = "select * from approvers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				approvalList.add(new Approvals(rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return approvalList;
	}
	

	public void insertApprover(Approvals aPerson) {
		//Connection conn = cf.getConnection();
		try {
			Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
			String sql = "insert into approvers values(DEFAULT,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aPerson.getUsername());
			ps.setString(2, aPerson.getPassword());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Approvals getApproverByName(String username) { // getAllApprovers()
		//Connection conn = cf.getConnection();
		Approvals aPerson = new Approvals();
		
		try {
			Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
			String sql = "select * from approvers where a_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				aPerson.setUsername(rs.getString(1));
				aPerson.setPassword(rs.getString(2));
				//vill.setSuperPower(rs.getString(2));
				//vill.setBounty(rs.getInt(3));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return aPerson;
	
	}

}
