package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Customer2;
import com.revature.model.Invoice2;
import com.revature.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int createCustomer(Customer2 customer) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int userPk = (Integer) s.save(customer);
		tx.commit();
		s.close();
		return userPk;
	}

	@Override
	public List<Customer2> getAllCusts() {
		Session s = HibernateUtil.getSession();
		List<Customer2> customers= s.createQuery("from Customer2", Customer2.class).list();
		s.close();
		return customers;
	}
	
	public void delete(int id)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Customer2 c = s.get(Customer2.class, id);
		if(c != null) {
			s.delete(c);
		}
		tx.commit();
		s.close();
	}

}
