package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.BalanceInfo;

public interface BalanceInfoDao {
	BalanceInfo getBalByID(int empID);
	public void updateAvailableBalance(BalanceInfo aPerson) throws SQLException, SQLException;
	//public void pullingAvailableBalance(BalanceInfo aPerson) throws SQLException;
}
