package com.bookmanage.service;

import com.bookmanage.bean.UserBean;

public interface ILoginService {
	/**
	 * 处理登录业务 
	 * @param ub 用户对象
	 * @return
	 */
	public boolean  login(UserBean ub);
	/**
	 *处理 注册业务 
	 * @param ub
	 * @return
	 */
	public boolean register(UserBean ub);
	
	/**
	 * 检查用户名和密码的数据格式
	 * @param ub
	 * @return
	 */
	public boolean checkUser(UserBean ub); 

}
