package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.CommunicationTable;

public interface CommunicationTableDao {

	
	List<CommunicationTable> getAllCommunicationTable() throws SQLException;
}
