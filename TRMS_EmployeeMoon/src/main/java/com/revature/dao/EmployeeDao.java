package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {

	List<Employee> getEmpUserPass() throws SQLException;
	public void insertEmployee(Employee ePerson)  throws SQLException;
    public Employee getEmployeeByName(String username) throws SQLException;
    public List<Employee> getAllEmployees();
}
