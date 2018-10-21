package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.BankUser;


public interface BankDao {
	public boolean insertBankCust(BankUser banker);
	public boolean insertBankCustomerProcedure(BankUser banker);
	public int Login(String user, String password);
	public boolean updateBankCustomer();
	public BankUser getBankUser();
	public ArrayList<BankUser> getAllBankCusts();
	public BankUser searchBankUser(String user);
	
	
}
