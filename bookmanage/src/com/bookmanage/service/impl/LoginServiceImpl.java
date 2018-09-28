package com.bookmanage.service.impl;

import com.bookmanage.bean.UserBean;
import com.bookmanage.dao.ILoginDao;
import com.bookmanage.dao.impl.LoginDaoImpl;
import com.bookmanage.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean login(UserBean ub) {
		// 返回登录结果,默认登录失败
		boolean result = false;
		// 调用检查页面上传用户数据格式是否正确
		boolean isFormat = checkUser(ub);

		// 格式检测成功，调用dao层调用findNameAndPass()方法进行数据库查询,获取查询结果
		if (isFormat == true) {
			ILoginDao ild = new LoginDaoImpl();
			UserBean userbean = ild.findNameAndPass(ub);
			// 数据库存在用户名和密码存在，登陆成功
			if (userbean.getUname().equals(ub.getUname()) && userbean.getPass().equals(ub.getPass())) {
				// 登录成功返回true
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean register(UserBean ub) {

		return false;
	}

	@Override
	public boolean checkUser(UserBean ub) {
		// 返回格式检查结果,默认格式不合法
		boolean result = false;

		if (ub != null) {
			// 用户名检查
			if (ub.getUname() != null && ub.getUname() != "" && ub.getUname().length() < 10) {
				// 用户名格式正确，继续检查密码格式
				if (ub.getPass() != null && ub.getPass() != "" && ub.getPass().length() < 10) {
					// 密码格式也正确，合法
					result = true;
				}
			}
		}
		return result;
	}

}
