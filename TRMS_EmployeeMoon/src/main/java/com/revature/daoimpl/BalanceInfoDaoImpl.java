package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BalanceInfoDao;
import com.revature.model.BalanceInfo;
import com.revature.model.Employee;
import com.revature.util.ConnFactory;

public class BalanceInfoDaoImpl implements BalanceInfoDao{
	
	
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public BalanceInfo getBalByID(int empID) { // getBalByID()
		Connection conn = cf.getConnection();
		BalanceInfo empBal = null;
		try {
			String sql = "select * from balanceinfo where empid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				empBal = new BalanceInfo(rs.getInt(1), rs.getDouble(2), rs.getDouble(3));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return empBal;
	}
	
	public void updateAvailableBalance(BalanceInfo aPerson) throws SQLException{
			Connection conn = cf.getConnection();
			String sql = "update balanceinfo set availbal=? where empid=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, aPerson.getAvailBal());
			ps.setInt(2, aPerson.getEmpId()); 
			ps.executeUpdate();
	
	}

//	public void pullingAvailableBalance(BalanceInfo aPerson) throws SQLException{
//		Connection conn = cf.getConnection();
//		String sql = "select * from balanceinfo where empid=?;"
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setDouble(1, aPerson.getAvailBal());
//		ps.setInt(2, aPerson.getEmpId()); 
//		ps.executeUpdate();
//		
//	
//	}
	
	
	

}
