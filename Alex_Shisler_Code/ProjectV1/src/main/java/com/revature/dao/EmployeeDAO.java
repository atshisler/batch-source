package com.revature.dao;

import com.revature.user.Employee;

public interface EmployeeDAO {
	public boolean insertEmployee(Employee Employee);

	public Employee getEmployee();

	public Employee searchEmployee();
}
