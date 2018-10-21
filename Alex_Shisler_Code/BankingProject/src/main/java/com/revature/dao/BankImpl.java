package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project0.BankUser;
import com.revature.util.BankConnectionUtil;

/*
 * Database Access and Model
 */

public class BankImpl implements BankDao {
	private static BankImpl bankDao;

	private ArrayList<BankUser> bankList;
	private BankUser currentUser;
	final static Logger Log = Logger.getLogger(BankImpl.class);

	private BankImpl() {
		bankList = new ArrayList<BankUser>();
	}

	public static BankImpl getBankDao() {
		if (bankDao == null) {
			bankDao = new BankImpl();
		}
		return bankDao;
	}// getBankDao

	@Override
	public boolean insertBankCust(BankUser banker) {
		// TODO Auto-generated method stub
		try (Connection conn = BankConnectionUtil.getConnection()) {
			String sql = "insert into infoUser values (?, ?, ?, ?, ?)";// 5 columns 5 ?'s, parameters
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, banker.getCid());
			ps.setString(2, banker.getAccountName());
			ps.setString(3, banker.getPassword());
			ps.setString(4, banker.getFirstName());
			ps.setString(5, banker.getLastName());
			ps.setString(6, banker.getRole());
			ps.setString(7, banker.getIsAccessible());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException s) {
			Log.error("Catch block in getCustomer - DAO Implementation - occured");
			s.getMessage();
			// s.printStackTrace();
		} finally {
			;// Log.warn("executed finally block");
		}

		return false;
	}// insertBankCust

	@Override
	public BankUser searchBankUser(String user) {
		// TODO Auto-generated method stub
		try (Connection conn = BankConnectionUtil.getConnection()) {
			String sql = "select * from userInfo where B_USERNAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				currentUser = new BankUser(rs.getInt("U_ID"), rs.getString("B_USERNAME"), rs.getString("B_PASSWORD"),
						rs.getString("B_FIRSTNAME"), rs.getString("B_LASTNAME"), rs.getString("B_ROLE"),
						rs.getString("isAccessible"));
				return currentUser;
			}
		} catch (SQLException s) {
			Log.error("Catch block in getBankUser - DAO Implementation - occured");
			System.out.println(s.getMessage());
		} finally {
			;// Log.warn("Executed finally block");
		}
		currentUser = new BankUser();
		return currentUser;

	}// getBankUser

	@Override
	public ArrayList<BankUser> getAllBankCusts() {
		// TODO Auto-generated method stub
		try (Connection conn = BankConnectionUtil.getConnection()) {
			String sql = "select * from userInfo";
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<BankUser> bankList = new ArrayList<BankUser>();
			while (rs.next()) {
				bankList.add(new BankUser(rs.getInt("U_ID"), rs.getString("B_USERNAME"), rs.getString("B_PASSWORD"),
						rs.getString("B_FIRSTNAME"), rs.getString("B_LASTNAME"), rs.getString("B_ROLE"),
						rs.getString("isAccessible")));
			} // while still has stuff
			return bankList;
		} catch (SQLException s) {
			Log.error("Catch block in getAllBankCusts - DAO Implementation - occured");
			System.out.println(s.getMessage());
		} finally {
			;// Log.warn("Executed finally block");
		}

		return new ArrayList<BankUser>();// never return null
	}// getAllBankCusts

	@Override
	public boolean insertBankCustomerProcedure(BankUser banker) {
		// TODO Auto-generated method stub
		try (Connection conn = BankConnectionUtil.getConnection()) {
			// Calling the store procedure
			String storedProc = "CALL INSERT_BANKCUSTOMER(?,?,?,?,?,?)";

			// Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement cs = conn.prepareCall(storedProc);
			cs.setInt(1, banker.getCid());
			cs.setString(2, banker.getAccountName());
			cs.setString(3, banker.getPassword());
			cs.setString(4, banker.getFirstName());
			cs.setString(5, banker.getLastName());
			cs.setString(6, banker.getRole());
			cs.setString(7, banker.getIsAccessible());
			// Set attributes to insert

			if (cs.executeUpdate() > 0) {
				cs.close();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Log.error("Catch block in inserBankCustomerProcedure - DAO Implementation - occured");
		}

		return false;
	}// insertBankCustomerProcedure

	@Override
	public boolean updateBankCustomer() {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int Login(String user, String pass) {
		// TODO Auto-generated method stub
		// ArrayList<BankUser> list = getAllBankCusts();
		currentUser = searchBankUser(user);
		if (pass.equals(currentUser.getPassword()))
			return getBankUser().getCid();
		/*
		 * for(int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i).getAccountName() + " user: " + user);
		 * if(list.get(i).getAccountName().equals(user)) {
		 * System.out.println(list.get(i).getPassword() + "entered password " + pass);
		 * if(list.get(i).getPassword().equals(pass)) return i; else return -1;
		 * }//username found }//username not found or failed password
		 */
		return -1;
	}

	public void getAccountInfo() {
		if (currentUser.getCid() != -1) {
			try (Connection conn = BankConnectionUtil.getConnection()) {
				String sql = "select * from accountInfo where U_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, currentUser.getCid());
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					currentUser.setAccountBal(rs.getDouble("B_BALANCE"));
				}
			} catch (SQLException s) {
				Log.error("Catch block in getAccountInfo - DAO Implementation - occured");
				System.out.println(s.getMessage());
			} finally {
				;// Log.warn("Executed finally block");
			}
		} // user exists
		else
			System.out.println("No account info is available.");

	}// getAccountInfo

	@Override
	public BankUser getBankUser() {
		// TODO Auto-generated method stub
		return currentUser;
	}

	public void deposit(double amount) {
		amount = Math.abs(amount);
		currentUser.deposit(amount);
		try (Connection conn = BankConnectionUtil.getConnection()) {
			String sql = "update accountInfo set B_BALANCE = ?, B_DEPOSIT = ? where U_ID = ?";
			CallableStatement cs = conn.prepareCall(sql);
			// PreparedStatement pstmt = conn.prepareStatement(sql);
			currentUser.deposit(amount);
			cs.setDouble(1, currentUser.getAccountBal());
			cs.setDouble(2, amount);
			cs.setInt(3, currentUser.getCid());
			if (cs.executeUpdate() > 0)
				System.out.println("Deposit successful.");
			// ResultSet rs = pstmt.executeQuery();

		} catch (SQLException s) {
			Log.error("Catch block in deposit - DAO Implementation - occured");
			System.out.println(s.getMessage());
		} finally {
			;// Log.warn("Executed finally block");
		}
	}// deposit

	public void withdrawal(double amount) {
		if (amount < 0) {
			System.out.println("Cannot withdraw a negative amount of money");
		} else {
			try (Connection conn = BankConnectionUtil.getConnection()) {
				String sql = "update accountInfo set B_BALANCE = ?, B_WITHDRAWAL = ? where U_ID = ?";
				CallableStatement cs = conn.prepareCall(sql);
				currentUser.withdrawal(amount);
				// PreparedStatement pstmt = conn.prepareStatement(sql);
				cs.setDouble(1, currentUser.getAccountBal());
				cs.setDouble(2, amount);
				cs.setInt(3, currentUser.getCid());
				if (cs.executeUpdate() > 0)
					System.out.println("Withdrawal successful.");
				// ResultSet rs = pstmt.executeQuery();

			} catch (SQLException s) {
				Log.error("Catch block in withdrawal - DAO Implementation - occured");
				System.out.println(s.getMessage());
			} finally {
				;// Log.warn("Executed finally block");
			}

		}

	}
}
