package com.revature.dao;

import java.util.List;

import com.revature.model.Customer2;

public interface CustomerDAO {
	public int createCustomer(Customer2 customer);
	public List<Customer2> getAllCusts();
	public void delete(int id);
}
