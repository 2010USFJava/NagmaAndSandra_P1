package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.BalanceInfo;
import com.revature.model.CommunicationTable;

public interface BalanceInfoDao {
	
	BalanceInfo getBalByID(int empID);
	public void updateAvailableBalance(BalanceInfo aPerson) throws SQLException;
	//public void pullingAvailableBalance(BalanceInfo aPerson) throws SQLException;
}


