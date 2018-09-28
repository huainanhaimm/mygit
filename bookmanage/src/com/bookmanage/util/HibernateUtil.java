package com.bookmanage.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

public class HibernateUtil {
	// session工厂
	private static SessionFactory fa = null;

	/**
	 * 获取到配置对象
	 * 
	 * @return
	 */
	public static Configuration getConfig() {
		Configuration config = new Configuration().configure();
		return config;

	}
	/**
	 * 获取session工厂对象
	 * @return
	 */
	public static SessionFactory getSessionFactory() {

		if (fa == null) {
			fa = getConfig().buildSessionFactory();
		}
		return fa;
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public static Session getSession() {
		Session session = getSessionFactory().openSession();
		return session;
	}
}
