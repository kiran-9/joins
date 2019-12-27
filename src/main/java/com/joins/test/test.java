package com.joins.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.joins.pojos.CarsPOJO;
import com.joins.pojos.LicencePOJO;
import com.joins.pojos.LocationPOJO;
import com.joins.pojos.PeoplePOJO;

public class test {
	
	public static void main(String[] args) {
		
//		save();
//		oneToManaySave();
//		oneToManyRead();
	}

	private static void oneToManyRead() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		CarsPOJO c = (CarsPOJO) session.get(CarsPOJO.class, "xuv500");
		
		System.out.println(c.getModel()+"--"+c.getColor()+"--"+c.getVarient());
		List<LocationPOJO> location = c.getLocation();
		for (LocationPOJO loc : location) {
			System.err.println(loc.getPincode()+"--"+loc.getCountry()+"--"+loc.getLocation());
			
		}
		
		
		/*
		 * LocationPOJO l = (LocationPOJO) session.get(LocationPOJO.class, 35468);
		 * System.out.println(l.getCountry()+"--"+l.getLocation()+"--"+l.getPincode()+
		 * "--"+l.getCars().getColor()+"--"+l.getCars().getModel()+"--"+l.getCars().
		 * getVarient());
		 */session.close();
		
	}

	private static <E> void oneToManaySave() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		CarsPOJO cars = new CarsPOJO();
		LocationPOJO location1 = new LocationPOJO();
		
		location1.setPincode(25435);
		location1.setLocation("noida");
		location1.setCountry("india");
		location1.setCars(cars);
		
		LocationPOJO location2 = new LocationPOJO();
		location2.setPincode(354688);
		location2.setLocation("chennai");
		location2.setCountry("india");
		location2.setCars(cars);
		
		LocationPOJO location3 = new LocationPOJO();
		location3.setPincode(92545);
		location3.setLocation("kerala");
		location3.setCountry("india");
		location3.setCars(cars);
		
		List<LocationPOJO> list = new ArrayList<LocationPOJO>();
		list.add(location3);
		list.add(location2);
		list.add(location1);
		
		cars.setModel("xuv500");
		cars.setColor("silver");
		cars.setVarient("petrol");
		cars.setLocation(list);
		
		session.save(location1);
		session.save(location2);
		session.save(location3);
		
		tx.commit();
		session.close();

		
		/*
		 * CarsPOJO cars = new CarsPOJO(); cars.setModel("i10"); cars.setColor("red");
		 * cars.setVarient("diesel");
		 * 
		 * 
		 * LocationPOJO l1 = new LocationPOJO(); l1.setPincode(2535);
		 * l1.setLocation("delhi"); l1.setCountry("india");
		 * 
		 * LocationPOJO l2 = new LocationPOJO(); l2.setPincode(1255);
		 * l2.setLocation("ca"); l2.setCountry("us");
		 * 
		 * LocationPOJO l3 = new LocationPOJO(); l3.setPincode(24588);
		 * l3.setLocation("domor"); l3.setCountry("canada");
		 * 
		 * List<LocationPOJO> list = new ArrayList<LocationPOJO>(); list.add(l1);
		 * list.add(l2); list.add(l3);
		 */		
		
	}

	private static void save() {

		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		LicencePOJO licence = new LicencePOJO();
		PeoplePOJO people = new PeoplePOJO();
		
		
		people.setName("nani");
		people.setMobile_number("4654654646");
		people.setLicence(licence);
		
		
		licence.setLicence_number("kd6646");
		licence.setLocation("hyd");
		licence.setIssued_year("2012");
		licence.setExpired_year("2018");
		licence.setPeople(people);
		
		session.save(people);
		tx.commit();
		session.close();
		
	}

}
