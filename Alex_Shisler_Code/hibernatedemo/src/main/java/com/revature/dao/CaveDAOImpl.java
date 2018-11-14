package com.revature.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Cave;
import com.revature.util.HibernateUtil;

public class CaveDAOImpl implements CaveDAO{

	@Override
	public List<Cave> getCaves() {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String hql = "from Cave";
		Query<Cave> q = s.createQuery(hql, Cave.class);
		List<Cave> caves = q.list();
		s.close();
		return caves;
	}

	@Override
	public Cave getCaveById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Cave c = s.get(Cave.class, id);
		s.close();
		return c;
	}

	@Override
	public int createCave(Cave c) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int cavePK = (int) s.save(c);
		tx.commit();
		s.close();
		return cavePK;
	}

	@Override
	public void updateCave(Cave c) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(c);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteCaveById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Cave c = (Cave) s.get(Cave.class, id);
		if(c != null) {
			s.delete(c);
		}
		tx.commit();
		s.close();
	}

}
