package com.woniuxy.comment.service;

import com.woniuxy.comment.bean.LoginBean;

public interface ILoginService {
	/**
	 * 
	 * @param lb:传入一个存条件
	 * @return 返回查询结果 表示是否查询成功（登录 成功）
	 */
	public LoginBean findPassByName(LoginBean lb ); 
	
	/**
	 * 处理 注册业务
	 * @return
	 */
	public String register(LoginBean lb);
	
	/**
	 * 通过uid得到用户名
	 * @param uid
	 * @return
	 */
	public String getName(int uid);
	
		/**
		 *检查用户名是否可用
		 * @return 
		 */
	public	String checkLoginName(String uname);

	/**
	 *检查密码是否可用
	 * @return 
	 */
	public boolean checkLoginPass(String pass);

}
