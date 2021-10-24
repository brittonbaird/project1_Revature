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

import com.revature.project1.model.Employee;

public class EmployeeDAO {
	
	public static EmployeeDAO instance() {
		EmployeeDAO dao= new EmployeeDAO();
		return dao;
	}

	public List<Employee> getEmployees() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class).setFetchMode("employee", FetchMode.JOIN);

		session.getTransaction().commit();
		
		return criteria.list();
	}
	
	public Employee getEmployee(String email) {
		Employee employee = new Employee();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		employee = session.createQuery("from Employee e where e.email = :email", Employee.class).setParameter("email", email).getSingleResult();
		
		session.getTransaction().commit();
		
		return employee;
	}
}
