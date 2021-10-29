package com.revature.project1.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

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
		
		session.close();
	}

	public List<Request> getRequests() {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Request> query = builder.createQuery(Request.class);
		Root<Request> root = query.from(Request.class);
		query.select(root);
				
		List<Request> requests = session.createQuery(query).getResultList();
				
		session.getTransaction().commit();
		session.close();
		return requests;
	}
	
	public List<Request> getRequestsByEmployeeId(int id) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		List<Request> requests;
		try {
			requests = session.createQuery("from Request where employeeid = :id", Request.class).setParameter("id", id).getResultList();
		} catch (Exception e) {
			requests = null;
		}
		
		
		session.getTransaction().commit();
		session.close();
		return requests;
	}
	
	public Request getRequest(int id) {
		Request request = new Request();
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		try {
			request = session.createQuery("from Request r where r.id = :id", Request.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			request = null;
		}
		
		
		session.getTransaction().commit();
		session.close();
		return request;
	}
	
	public void updateRequest(Request request) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		session.update(request);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteRequest(Request request) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		session.delete(request);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
