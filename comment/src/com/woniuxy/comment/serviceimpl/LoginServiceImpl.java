package com.woniuxy.comment.serviceimpl;

import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.dao.ILoginDAO;
import com.woniuxy.comment.daoimpl.LoginDAOImpl;
import com.woniuxy.comment.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	private ILoginDAO dao = new LoginDAOImpl();

	/**
	 * 处理登录业务
	 */
	@Override
	public LoginBean findPassByName(LoginBean lb) {
		// 存储查询结果
		boolean result = false;
		LoginBean bean = dao.findByNameAndPass(lb);
		return bean;
	}

	/**
	 * 注册账户业务
	 */
	@Override
	public String register(LoginBean lb) {
		// 存储注册结果（成功、失败）
		String result = "注册失败";
		// 在页面传来的数据数据检测正确后进行数据库插入操纵，同时返回sql插入语句的影响行数row
		// 获取用户名检验结果
		String unameResult = checkLoginName(lb.getUname());
		// 获取密码检验结果
		boolean passIsOK = checkLoginPass(lb.getPass());
		// 用户名验通过证通过
		if (unameResult.equals("可注册")) {
			// 开始验证密码是否合法
			if (passIsOK == false) {
				// 不合法
				result = "用户密码不合法！";
			} else {
				result = "可注册";
			}
		} else {
			// 用户名验证不通过通过
			result = unameResult;
		}

		// 用户名和密码都合法，开始执行插入数据库的操作
		if (result.equals("可注册")) {
			// 返回插入数据库 后的影响行数
			int row = dao.insertAll(lb);
			// 如果返回行数大于0则插入成功，否者失败
			if (row > 0) {
				result = "注册成功";
			} else {
				result = "注册失败！";
			}

		}
		return result;

	}

	/**
	 * 检查用户输入信息的正确性
	 */
	@Override
	public String checkLoginName(String uname) {
		// 存储查用户名检查后是否合法的结果
		String result = "";	
		// 检查用户名是否合法（长度是否在10以内，是否为字符串）
		// 不合法
		if (uname.length() > 10) {
			result = "用户名不合法";
			// 合法,接着判断数据库中是否已经存在账号
		} else {
			// 查询结果为为null（表示可注册）
			if (dao.findByName(uname) == null) {

				result = "可注册";
			} else {
				// 查询结果不为空（用户名已经存在）
				result = "用户名已经存在";
			}
		}
		return result;
	}

	@Override
	public boolean checkLoginPass(String pass) {
		boolean result = false;
		// 判断密码是否合法（密码标准：长度在6个以内包括6的字符串）
		// 合法
		if (pass.length() <= 6) {
			result = true;
		}
		return result;
	}

	//通过uid查询unam
	@Override
	public String getName(int uid) {
		String result = dao.findNameById(uid); 
		return result;
	}

}
