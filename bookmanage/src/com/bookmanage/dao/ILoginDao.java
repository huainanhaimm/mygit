package com.bookmanage.dao;

import com.bookmanage.bean.UserBean;

public interface ILoginDao {
	
	/**
	 * 通过姓名和密码查找用户信息
	 * @param ub 用户信息
	 * @return 返回查询到的用户信息
	 */
	public UserBean findNameAndPass(UserBean ub);
	
	/**
	 * 向数据库插入用户信息
	 * @param ub 用户信息
	 * @return 影响行数
	 */
	public int  insertUserBean(UserBean ub);
		
}
