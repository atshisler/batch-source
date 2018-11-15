package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Bear;
import com.revature.util.HibernateUtil;

public interface BearDAO {

	public List<Bear> getBears();
	public Bear getBearById(int id);
	public int createBear(Bear b);
	public long getBearCount();
	public void updateBear(Bear b);
	public void deleteBearById(int id);
	public List<Bear> getBearsByName(String name);
}
