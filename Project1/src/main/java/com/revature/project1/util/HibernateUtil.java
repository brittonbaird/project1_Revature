package com.revature.project1.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	private static Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	private static SessionFactory factory = meta.getSessionFactoryBuilder().build();
	
	public static SessionFactory getFactory() {
		return factory;
	}
}
