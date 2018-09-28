package com.woniuxy.comment.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

public class RegisterAction extends ActionSupport {

	ILoginService ilogin = new LoginServiceImpl();
	// �洢ע��ҳ���ύ�����ݣ�����������
	private String uname;
	private String pass;
	private String passCheck;
	private String result;

	// ��д�����ⷽ������ҳ���ϴ������ݼ��
	@Override
	public void validate() {
		// ���ע����û���Ϊ��
		if (uname.length() == 0) {
			addFieldError("unameError", "�û�������Ϊ�գ�");
			// ���ע�������Ϊ��
		} else if (pass.length() == 0) {
			addFieldError("passError", "���벻��Ϊ�գ�");
			// ���ע��������������벻һ��
		} else if (passCheck.equals(pass) != true) {
			addFieldError("passCheckError", "������������벻һ�£�");
		}

	}

	public String execute() {
		// ����ֵ
		String returnValues = "fail";
		// �����յ������ݷ�װ��LoginBean
		LoginBean lb = new LoginBean();
		lb.setUname(uname);
		lb.setPass(pass);
		// ����ҵ���ִ��ע��ҵ�񣬻�ȡע����
		result = ilogin.register(lb);
		// ��ȡֵջ����
		ActionContext content = ActionContext.getContext();

		// ����ȡ����ע���Ƿ�ɹ�����Ϣ����ֵջ��request��������
		content.put("result", result);
		if (result.equals("��ע��")) {
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
