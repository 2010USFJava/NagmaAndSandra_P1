package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Approvals;
import com.revature.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	public void insertEmployee(Employee ePerson)  throws SQLException;
    public Employee getEmployeeByName(String username) throws SQLException;

}
