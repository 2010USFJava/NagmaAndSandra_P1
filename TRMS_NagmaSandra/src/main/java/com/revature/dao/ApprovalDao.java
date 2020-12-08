package com.revature.dao;


import java.sql.SQLException;
import java.util.List;

import com.revature.model.Approvals;

public interface ApprovalDao {
	
	

	public void insertApprover(Approvals aPerson)  throws SQLException;
	public List<Approvals> getAllApprovers() throws SQLException;
    public Approvals getApproverByName(String username) throws SQLException;
    //public void deleteUser(Register p) throws SQLException;
    //public void registerCustomer(Register p) throws SQLException;
}
