package com.bookmanage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.bookmanage.bean.BookBean;
import com.bookmanage.bean.UserBean;
import com.bookmanage.dao.IBookDao;
import com.bookmanage.util.HibernateUtil;

public class BookDaoImpl implements IBookDao {
	@Override
	public Long findAll() {
		Long result = 0L;
		// 获取session
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("select count(uid) as num from UserBean");
		List<Long> list = query.list();
		result = list.get(0);
		return result;
	}

	@Override
	public List<BookBean> findSixById(int index) {
		List<BookBean> list = null;
		// 获取session
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from BookBean");		
		//从第一条数据开始提取
		query.setFirstResult(index);
		//每次最大提取6条
		query.setMaxResults(6);
		list = query.list();
		return list;
	}

}
