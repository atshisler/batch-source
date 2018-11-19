package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Customer2;
import com.revature.model.Invoice2;
import com.revature.util.HibernateUtil;

public class InvoiceDAOImpl implements InvoiceDAO{

	public int createInvoice(Invoice2 invoice) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int userPk = (Integer) s.save(invoice);
		tx.commit();
		s.close();
		return userPk;
		
	}

	public Invoice2 getInvoiceById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("getByIdQuery");
		q.setParameter("idVar", id);
		Invoice2 invoice = (Invoice2) q.getSingleResult();
		s.close();
		return invoice;
	}

	public List<Invoice2> getAllInvoices() {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		List<Invoice2> invoices = s.createQuery("from Invoice2", Invoice2.class).list();
		s.close();
		return invoices;
	}
	
	public void delete(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice2 inv = s.get(Invoice2.class, id);
		if(inv != null) {
			s.delete(inv);
		}
		tx.commit();
		s.close();
	}

}
