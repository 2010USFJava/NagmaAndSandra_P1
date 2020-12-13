package com.revature.dao;

import com.revature.model.BalanceInfo;

public interface BalanceInfoDao {
	BalanceInfo getBalByID(int empID);
}
