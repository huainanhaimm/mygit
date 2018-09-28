package com.woniuxy.comment.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

//继承ActionSupport使用struts框架提供的验证方法，实现ModelDriven接口是为了绑定LoginBean对象和接收到的页面传参
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean> {

	// 存储来自登录页面的数据（属性驱动获取）
	private LoginBean lb = new LoginBean();
	// 存储登录结果
	private boolean result;

	// 模型驱动
	@Override
	public LoginBean getModel() {

		return lb;
	}

	// 重写父类的验证方法，实现页面传来的数据 的验证
	@Override
	public void validate() {
		if (lb.getUname().length() == 0) {
			addFieldError("nameError", "用户名不能为空");
		} else if (lb.getPass().length() == 0) {
			addFieldError("pwdError", "密码不能为空");
		}
	}

	public String execute() {
		ILoginService login = new LoginServiceImpl();

		String returnResult = "fail";
		// 获取登录结果
		LoginBean bean = login.findPassByName(lb);

		// // 获取值栈对象
		// ValueStack valueStack = ActionContext.getContext().getValueStack();
		if (bean != null) {
			// 登录成功
			result = true;
			returnResult = "success";
			// 将获取到的用户名用户密码用户id存入值栈中context中的session中
			ActionContext.getContext().getSession().put("acount", bean);

		} else {
			// "登录失败";
			result = false;
		}

		// 将获取到的值存入值栈中context中的session中
		ActionContext.getContext().getSession().put("LoginResult", result);

		return returnResult;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
