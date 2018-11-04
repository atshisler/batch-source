package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.user.Employee;
import com.revature.util.ConnectionUtilV1;



public class EmployeeDAOImpl implements EmployeeDAO {
	final static Logger Log = Logger.getLogger(EmployeeDAOImpl.class);
/*----------------------Variables----------------------------------*/
	
	private EmployeeDAOImpl() {
		;
	}

	public boolean insertEmployee(Employee employee) {
		ConnectionUtilV1 conn1 = ConnectionUtilV1.getInstance();
		try (Connection conn2 = conn1.getConnection()) {
			String sql = "insert into employeeTable values (sequence_1.nextval, ?, ?, ?, ?)";
																								// parameters
			PreparedStatement ps = conn2.prepareStatement(sql);
			// ps.setInt(1, banker.getCid());
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirstName());
			ps.setString(4, employee.getLastName());
			
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException s) {
			Log.error("Catch block in getCustomer - DAO Implementation - occured");
			System.out.println(s.getMessage());
			// s.printStackTrace();
		} finally {
			;// Log.warn("executed finally block");
		}

		return false;
	}

	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee searchEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
}
