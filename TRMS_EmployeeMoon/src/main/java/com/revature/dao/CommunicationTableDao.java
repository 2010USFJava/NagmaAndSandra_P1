package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.CommunicationTable;

public interface CommunicationTableDao {

	
	List<CommunicationTable> getAllCommunicationTable() throws SQLException;
	
	CommunicationTable updateCommTable(CommunicationTable commTable);
	
	public void insertIntoCommunicationForm(CommunicationTable ePerson) throws SQLException;
	
	public void updateMgmtInfo(CommunicationTable ePerson) throws SQLException;	
	
	public void updateDirMgrInfo(CommunicationTable ePerson) throws SQLException;
	
	public void updateDirSupInfo(CommunicationTable ePerson) throws SQLException;
	
	public void updateDeptHeadInfo(CommunicationTable ePerson) throws SQLException;
		
	public void updateBencoInfo(CommunicationTable ePerson) throws SQLException;

}
	
