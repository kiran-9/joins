package com.joins.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.joins.pojos.Clint;
import com.joins.pojos.Service;

public class TestManyToMany {
	
	public static void main(String[] args) {
		
//		save();
		read();
		
	}

	private static void read() {
		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.get(Clint.class, "vogo");
		System.out.println(Clint.class);
		
		
	}

	private static void save() {
		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		ArrayList<Clint> List1 = new ArrayList<Clint>();
		ArrayList<Clint> List2 = new ArrayList<Clint>();
		ArrayList<Clint> List3 = new ArrayList<Clint>();
		
		ArrayList<Service> sList1 = new ArrayList<Service>();
		ArrayList<Service> sList2 = new ArrayList<Service>();
		ArrayList<Service> sList3 = new ArrayList<Service>();
		
		Service service1 = new Service();
		service1.setLocation("india");
		service1.setServiceId(138);
		service1.setType("ride share");
		service1.setClint(List2);
		
		Service service2 = new Service();
		service2.setLocation("india");
		service2.setServiceId(137);
		service2.setType("ride share");
		service1.setClint(List1);
		
		Service service3 = new Service();
		service3.setLocation("india");
		service3.setServiceId(136);
		service3.setType("logistics");
		service3.setClint(List3);
		
		sList1.add(service1);
		sList1.add(service2);
		
		sList2.add(service2);
		
		sList3.add(service3);
		
		Clint clint1 = new Clint();
		clint1.setName("ZANTT");
		clint1.setEmpliyees(1500);
		clint1.setOffice("pune");
		clint1.setService(sList1);
		
		Clint clint2 = new Clint();
		clint2.setName("scott");
		clint2.setEmpliyees(1220);
		clint2.setOffice("chennai");
		clint2.setService(sList2);
		
		Clint clint3 = new Clint();
		clint3.setName("vogo");
		clint3.setEmpliyees(15000);
		clint3.setOffice("banglore");
		clint3.setService(sList3);
		
		List1.add(clint3);
		List1.add(clint2);
		
		List2.add(clint1);
		List2.add(clint3);
		
		List3.add(clint1);
		/*
		 * clint1.setName("jjk"); clint1.setOffice("hyderabad");
		 * clint1.setEmpliyees(1500);
		 * 
		 * Clint clint2 = new Clint(); clint2.setName("phone pe");
		 * clint2.setOffice("delhi"); clint2.setEmpliyees(200);
		 * 
		 * Clint clint3 = new Clint(); clint3.setName("zomato");
		 * clint3.setOffice("mumbai"); clint3.setEmpliyees(2500);
		 * 
		 * ArrayList<Clint> clist1 = new ArrayList<Clint>(); clist1.add(clint1);
		 * clist1.add(clint2);
		 * 
		 * ArrayList<Clint> clist2 = new ArrayList<Clint>(); clist2.add(clint2);
		 * clist2.add(clint3);
		 * 
		 * ArrayList<Clint> clist3 = new ArrayList<Clint>(); clist3.add(clint1);
		 * 
		 * 
		 * Service service1 = new Service(); service1.setServiceId(115);
		 * service1.setType("food delevery"); service1.setLocation("india");
		 * service1.setClint(clist2);
		 * 
		 * Service service2 = new Service(); service2.setServiceId(114);
		 * service2.setType("financial"); service2.setLocation("india");
		 * service2.setClint(clist3);
		 * 
		 * 
		 * Service service3 = new Service(); service3.setServiceId(113);
		 * service3.setType("bike rental"); service3.setLocation("india");
		 * service3.setClint(clist1);
		 * 
		 * ArrayList<Service> slist1 = new ArrayList<Service>(); slist1.add(service3);
		 * slist1.add(service1);
		 * 
		 * ArrayList<Service> slist2 = new ArrayList<Service>(); slist2.add(service2);
		 * slist2.add(service1);
		 * 
		 * ArrayList<Service> slist3 = new ArrayList<Service>(); slist3.add(service1);
		 */	
		
		/*
		 * clint1.setService(slist1); clint2.setService(slist2);
		 * clint3.setService(slist3);
		 */		
		
		session.save(clint1);
		session.save(clint2);
		session.save(clint3);
		tx.commit();
		session.close();
	}

}
