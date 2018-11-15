package com.revature.util;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.models.Bear;
import com.revature.models.Cave;

public class Driver {
 public static void main(String[] args) {
	Session s = HibernateUtil.getSession();
	s.close();
	 
	
	CaveDAO cd = new CaveDAOImpl();
	 Cave c1 = new Cave("Luray Caverns");
	 Cave c2 = new Cave("Dixie Caverns");
	 Cave c3 = new Cave("Bat Cave");
	 
	 //cd.createCave(c1);
	 //cd.createCave(c2);
	 //cd.createCave(c3);
	
	 
	 Bear b1 = new Bear("Yogi", Date.valueOf("1950-02-08"), c1);
	 Bear b2 = new Bear("Smokey", Date.valueOf("1934-06-10"), c2);
	 Bear b3 = new Bear("Ted", Date.valueOf("1999-02-11"), c2);
	 
	 
	 //cd.deleteCaveById(1);
	 //cd.deleteCaveById(2);

	 List<Cave> caves = cd.getCaves();
	 for(Cave c: caves) {
		 ;//System.out.println(c);
	 }
	 
	 //System.out.println(cd.getCaveById(5));
	 
	 BearDAO bd = new BearDAOImpl();
	 
	 
	 List<Bear> bears = bd.getBears();
	 //bd.createBear(b1);
	 //bd.createBear(b2);
	 //bd.createBear(b3);
	 
	 System.out.println(bd.getBearById(2));
	 //System.out.println(bd.getBearsByName("Yogi"));
	 
	 //System.out.println(bd.getBearCount());
	 for(Bear b: bears) {
		 ;//	 System.out.println(b);
	 }
	 
}
}
