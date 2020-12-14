package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.EmployeeForm;

public interface EmployeeFormDao {
	
	List<EmployeeForm> getAllEmployeesForm() throws SQLException;
	void saveEmployeeForm(EmployeeForm ef);
	List<EmployeeForm>getAllFormsByEmp(int empId);
}