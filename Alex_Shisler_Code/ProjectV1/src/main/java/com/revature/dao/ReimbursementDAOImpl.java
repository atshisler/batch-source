package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.user.Employee;
import com.revature.util.ConnectionUtilV1;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	final static Logger Log = Logger.getLogger(ReimbursementDAOImpl.class);
	
	private ReimbursementDAOImpl() {
		;
	}

	@Override
	public boolean insertReimbursements(Employee employee) {
		// TODO Auto-generated method stub
		ConnectionUtilV1 conn1 = ConnectionUtilV1.getInstance();
		try (Connection conn2 = conn1.getConnection()) {
			// ------------reimbursementTable insert---------//
			String sql = "insert into reimbursementTable values (sequence_1.currval, sequence_1.currval, ?, ?)";
			PreparedStatement cs = conn2.prepareStatement(sql);
			cs.setDouble(1, 0.00);
			cs.setDouble(2, employee.getReimbursement());
			cs.setString(3, employee.getStatus());
			if (cs.executeUpdate() > 0) {
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

	@Override
	public Employee getReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee searchReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

}
