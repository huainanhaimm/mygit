package com.woniuxy.comment.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

//�̳�ActionSupportʹ��struts����ṩ����֤������ʵ��ModelDriven�ӿ���Ϊ�˰�LoginBean����ͽ��յ���ҳ�洫��
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean> {

	// �洢���Ե�¼ҳ������ݣ�����������ȡ��
	private LoginBean lb = new LoginBean();
	// �洢��¼���
	private boolean result;

	// ģ������
	@Override
	public LoginBean getModel() {

		return lb;
	}

	// ��д�������֤������ʵ��ҳ�洫�������� ����֤
	@Override
	public void validate() {
		if (lb.getUname().length() == 0) {
			addFieldError("nameError", "�û�������Ϊ��");
		} else if (lb.getPass().length() == 0) {
			addFieldError("pwdError", "���벻��Ϊ��");
		}
	}

	public String execute() {
		ILoginService login = new LoginServiceImpl();

		String returnResult = "fail";
		// ��ȡ��¼���
		LoginBean bean = login.findPassByName(lb);

		// // ��ȡֵջ����
		// ValueStack valueStack = ActionContext.getContext().getValueStack();
		if (bean != null) {
			// ��¼�ɹ�
			result = true;
			returnResult = "success";
			// ����ȡ�����û����û������û�id����ֵջ��context�е�session��
			ActionContext.getContext().getSession().put("acount", bean);

		} else {
			// "��¼ʧ��";
			result = false;
		}

		// ����ȡ����ֵ����ֵջ��context�е�session��
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
