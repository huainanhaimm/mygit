package com.woniuxy.comment.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

public class RegisterAction extends ActionSupport {

	ILoginService ilogin = new LoginServiceImpl();
	// 存储注册页面提交的数据（属性驱动）
	private String uname;
	private String pass;
	private String passCheck;
	private String result;

	// 重写父类检测方法进行页面上传的数据检测
	@Override
	public void validate() {
		// 如果注册的用户名为空
		if (uname.length() == 0) {
			addFieldError("unameError", "用户名不能为空！");
			// 如果注册的密码为空
		} else if (pass.length() == 0) {
			addFieldError("passError", "密码不能为空！");
			// 如果注册两次输入的密码不一致
		} else if (passCheck.equals(pass) != true) {
			addFieldError("passCheckError", "两次输入的密码不一致！");
		}

	}

	public String execute() {
		// 返回值
		String returnValues = "fail";
		// 将接收到的数据封装到LoginBean
		LoginBean lb = new LoginBean();
		lb.setUname(uname);
		lb.setPass(pass);
		// 调用业务层执行注册业务，获取注册结果
		result = ilogin.register(lb);
		// 获取值栈对象
		ActionContext content = ActionContext.getContext();

		// 将获取到的注册是否成功的信息存入值栈中request作用域中
		content.put("result", result);
		if (result.equals("可注册")) {
			returnValues = "success";
		}

		return returnValues;
	}

	public String isResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassCheck() {
		return passCheck;
	}

	public void setPassCheck(String passCheck) {
		this.passCheck = passCheck;
	}

}
