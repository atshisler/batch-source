package com.revature.dao;

import com.revature.user.Employee;

public interface ReimbursementDAO {
	public boolean insertReimbursements(Employee employee);

	public Employee getReimbursement();

	public Employee searchReimbursements();
}
