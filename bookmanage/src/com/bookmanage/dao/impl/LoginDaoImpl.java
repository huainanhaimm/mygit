package com.bookmanage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bookmanage.bean.UserBean;
import com.bookmanage.dao.ILoginDao;
import com.bookmanage.util.HibernateUtil;

public class LoginDaoImpl implements ILoginDao {

	@Override
	public UserBean findNameAndPass(UserBean ub) {
		UserBean result = null;
		// ªÒ»°session
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from UserBean");
		List<UserBean> list = query.list();
		result = list.get(0);
		return result;
	}

	@Override
	public int insertUserBean(UserBean ub) {
		// TODO Auto-generated method stub
		return 0;
	}

}
