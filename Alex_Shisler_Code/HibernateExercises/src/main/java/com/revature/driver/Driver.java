package com.revature.driver;

import java.sql.Date;

import java.util.List;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.InvoiceDAO;
import com.revature.dao.InvoiceDAOImpl;
import com.revature.model.Customer2;
import com.revature.model.Invoice2;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvoiceDAO invd = new InvoiceDAOImpl();
		CustomerDAO cd = new CustomerDAOImpl();
		invd.createInvoice(new Invoice2(Date.valueOf("2015-05-17"), 50.00));
		invd.createInvoice(new Invoice2(Date.valueOf("2002-02-08"), 850.00));
		invd.createInvoice(new Invoice2(Date.valueOf("1968-07-31"), 999.00));
		cd.createCustomer(new Customer2("Ted", "555-555-5555"));
		cd.createCustomer(new Customer2("Charlie", "610-448-6466"));
		List<Invoice2> invoiceList = invd.getAllInvoices();
		List<Customer2> custList = cd.getAllCusts();

		for(Invoice2 invoice : invoiceList) {
			System.out.println(invoice.toString());
			//invd.delete(invoice.getId());
		}
		
		for(Customer2 customer : custList) {
			System.out.println(customer.toString());
			//cd.delete(customer.getId());
		}
		

	}

}
