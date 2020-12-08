package com.revature.dao;


import java.sql.SQLException;
import java.util.List;

import com.revature.model.Approval;

public interface ApprovalDao {
	
	

	public void insertApprover(Approval aPerson)  throws SQLException;
	public List<Approval> getAllApprovers() throws SQLException;
    public Approval getApproverByName(String username) throws SQLException;
    //public void deleteUser(Register p) throws SQLException;
    //public void registerCustomer(Register p) throws SQLException;
}
