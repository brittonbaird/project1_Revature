package com.revature.project1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.revature.project1.model.Request;


public class RequestDAO {
	
	public static RequestDAO instance() {
		RequestDAO dao= new RequestDAO();
		return dao;
	}
	
	public void saveRequest(Request request) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(request);
		
		session.getTransaction().commit();
	}

	public List<Request> getRequests() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Request.class).setFetchMode("request", FetchMode.JOIN);
		
		session.getTransaction().commit();
		
		return criteria.list();
	}
	
	public void updateRequest(Request request) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.update(request);
		
		session.getTransaction().commit();
	}
	
}
