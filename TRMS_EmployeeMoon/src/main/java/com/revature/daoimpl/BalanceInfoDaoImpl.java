package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
