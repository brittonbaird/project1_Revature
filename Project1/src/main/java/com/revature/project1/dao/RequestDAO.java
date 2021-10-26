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
import com.revature.project1.util.HibernateUtil;


public class RequestDAO {
	
	public static RequestDAO instance() {
		RequestDAO dao= new RequestDAO();
		return dao;
	}
	
	public void saveRequest(Request request) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		session.save(request);
		
		session.getTransaction().commit();
	}

	public List<Request> getRequests() {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Request.class).setFetchMode("request", FetchMode.JOIN);
		
		session.getTransaction().commit();
		
		return criteria.list();
	}
	
	public void updateRequest(Request request) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		session.update(request);
		
		session.getTransaction().commit();
	}
	
}
