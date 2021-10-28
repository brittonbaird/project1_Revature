package com.revature.project1.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.revature.project1.model.Employee;

import com.revature.project1.util.HibernateUtil;

public class EmployeeDAO {
	
	public static EmployeeDAO instance() {
		EmployeeDAO dao= new EmployeeDAO();
		return dao;
	}

	public List<Employee> getEmployees() {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(root);
				
		List<Employee> employees = session.createQuery(query).getResultList();
		session.getTransaction().commit();
		
		return employees;
	}
	
	public Employee getEmployee(String email) {
		Employee employee = new Employee();
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		try {
			employee = session.createQuery("from Employee e where e.email = :email", Employee.class).setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			employee = null;
		}
		
		
		session.getTransaction().commit();
		
		return employee;
	}
	
	public void saveEmployee(Employee employee) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit();
	}
}
