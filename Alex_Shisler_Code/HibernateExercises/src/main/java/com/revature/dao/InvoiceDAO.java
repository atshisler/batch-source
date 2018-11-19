package com.revature.dao;

import java.util.List;

import com.revature.model.Invoice2;

public interface InvoiceDAO {

	public int createInvoice(Invoice2 invoice);
	public Invoice2 getInvoiceById(int id);
	public List<Invoice2> getAllInvoices();
	public void delete(int id);
}
